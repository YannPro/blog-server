package com.yannyao.demo.service.Impl;

import com.yannyao.demo.bean.Admin;
import com.yannyao.demo.bean.AdminTableMessage;
import com.yannyao.demo.mapper.AdminMapper;
import com.yannyao.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class UserServiceImpl implements AdminService{
    @Autowired
    private AdminMapper userMapper;
    @Override
    public List<Admin> getList() {
        List<Admin> userList = new ArrayList<>();
        try {
            userList = userMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userList;
    }

    @Override
    public Admin getById(Integer id) {
        Admin user = new Admin();
        try {
            user = userMapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public AdminTableMessage getSearchList(AdminTableMessage tableMessage) {
        return null;
    }

    @Override
    public boolean add(Admin user) {

        boolean state = false;
        try {
            state = userMapper.insert(user) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean update(Admin user) {
        boolean state = false;
        try {
            state = userMapper.update(user) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean delete(Integer id) {
        boolean state = false;
        try {
            state = userMapper.delete(id) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean validate(Admin user) {
        return false;
    }
}
