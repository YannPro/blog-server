package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.ArticleClass;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    /**
     * 获取类别列表
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Message getList(){

        List<ArticleClass> classList = new ArrayList<>();

        try {
            classList = classService.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取类别列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取类别列表成功！",classList);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Message add(@RequestBody ArticleClass clazz){
        System.out.println(clazz.toString());
        try {
            if(classService.add(clazz)){
                return new Message(Message.SUCCESS,"新增类别成功！",null);
            }else{
                return new Message(Message.ERROR,"新增类别失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"新增类别失败！",null);
        }
    }

    /**
     * 删除类别
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message delete(@PathVariable(value = "id") Integer id){
        try {
            if(classService.delete(id)){
                return new Message(Message.SUCCESS,"删除类别成功！",null);
            }else{
                return new Message(Message.ERROR,"删除类别失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"删除类别失败！",null);
        }
    }
}
