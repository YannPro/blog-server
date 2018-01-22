package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.FriendLink;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.service.LinkService;
import com.yannyao.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 获取友链列表
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Message getList(){

        List<FriendLink> linkList = new ArrayList<>();

        try {
            linkList = linkService.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取友链列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取友链列表成功！",linkList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Message add(@RequestBody FriendLink friendLink){
        System.out.println(friendLink.toString());
        try {
            if(linkService.add(friendLink)){
                return new Message(Message.SUCCESS,"新增友链成功！",null);
            }else{
                return new Message(Message.ERROR,"新增友链失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"新增友链失败！",null);
        }
    }
    /**
     * 修改友链
     * @param friendLink
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Message update(@PathVariable("id") Integer id, @RequestBody FriendLink friendLink) {
        try {
            friendLink.setId(id);
            FriendLink result = linkService.update(friendLink);
            if (result != null) {
                return new Message(Message.SUCCESS, "修改友链成功！", result);
            } else {
                return new Message(Message.ERROR, "修改友链失败！", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR, "修改友链失败！", null);
        }
    }
    /**
     * 删除友链
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Message delete(@RequestParam(value = "adminId") Integer id){
        try {
            if(linkService.delete(id)){
                return new Message(Message.SUCCESS,"删除友链成功！",null);
            }else{
                return new Message(Message.ERROR,"删除友链失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"删除友链失败！",null);
        }
    }
}
