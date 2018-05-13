package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.User;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Message getList(){

        List<User> userList = new ArrayList<>();

        try {
            userList = userService.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取用户列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取用户列表成功！",userList);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public Message getById(@RequestParam("userId") Integer id){
        User user = new User();
        try {
            user = userService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取用户失败！", null);
        }
        return new Message(Message.SUCCESS,"获取用户成功！",user);
    }
    /**
     * 获取用户列表(有分页)
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Message getList(@RequestParam int limit,
                           @RequestParam int page){

        BaseTableMessage tableMessage = new BaseTableMessage();
        try {
            tableMessage = userService.getList(page, limit);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取用户列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取文章列表成功！",tableMessage);
    }
    /**
     * 根据
     * @param tableMessage
     * @return
     */
    @RequestMapping(value = "/getSearchList", method = RequestMethod.POST)
    @ResponseBody
    public Map getSearchList(@RequestBody BaseTableMessage tableMessage) throws Exception{
        System.out.println(tableMessage);
        return userService.getSearchList(tableMessage).result();
    }
    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Message add(@RequestBody User user){
        System.out.println(user.toString());
        try {
            if(userService.add(user)){
                return new Message(Message.SUCCESS,"新增用户成功！",null);
            }else{
                return new Message(Message.ERROR,"新增用户失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"新增用户失败！",null);
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Message update(@RequestBody User user){
        try {
            if(userService.update(user)){
                return new Message(Message.SUCCESS,"修改用户成功！",null);
            }else{
                return new Message(Message.ERROR,"修改用户失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"修改用户失败！",null);
        }
    }
    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Message delete(@RequestParam(value = "userId") Integer id){
        try {
            if(userService.delete(id)){
                return new Message(Message.SUCCESS,"删除用户成功！",null);
            }else{
                return new Message(Message.ERROR,"删除用户失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"删除用户失败！",null);
        }
    }
}
