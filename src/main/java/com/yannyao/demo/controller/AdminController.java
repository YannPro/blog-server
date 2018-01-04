package com.yannyao.demo.controller;

import com.yannyao.demo.bean.Admin;
import com.yannyao.demo.bean.AdminTableMessage;
import com.yannyao.demo.bean.Message;
import com.yannyao.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 获取管理员列表
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Message getList(){

        List<Admin> adminList = new ArrayList<>();

        try {
            adminList = adminService.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取管理员列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取管理员列表成功！",adminList);
    }

    /**
     * 根据id查询管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public Message getById(@RequestParam("adminId") Integer id){
        Admin admin = new Admin();
        try {
            admin = adminService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取管理员失败！", null);
        }
        return new Message(Message.SUCCESS,"获取管理员成功！",admin);
    }

    /**
     * 根据
     * @param tableMessage
     * @return
     */
    @RequestMapping(value = "/getSearchList", method = RequestMethod.POST)
    @ResponseBody
    public Map getSearchList(@RequestBody AdminTableMessage tableMessage) throws Exception{
        System.out.println(tableMessage);
        return adminService.getSearchList(tableMessage).result();
    }
    /**
     * 新增管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Message add(@RequestBody Admin admin){
        System.out.println(admin.toString());
        try {
            if(adminService.add(admin)){
                return new Message(Message.SUCCESS,"新增管理员成功！",null);
            }else{
                return new Message(Message.ERROR,"新增管理员失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"新增管理员失败！",null);
        }
    }

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Message update(@RequestBody Admin admin){
        try {
            if(adminService.update(admin)){
                return new Message(Message.SUCCESS,"修改管理员成功！",null);
            }else{
                return new Message(Message.ERROR,"修改管理员失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"修改管理员失败！",null);
        }
    }
    /**
     * 删除管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Message delete(@RequestParam(value = "adminId") Integer id){
        try {
            if(adminService.delete(id)){
                return new Message(Message.SUCCESS,"删除管理员成功！",null);
            }else{
                return new Message(Message.ERROR,"删除管理员失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"删除管理员失败！",null);
        }
    }
}
