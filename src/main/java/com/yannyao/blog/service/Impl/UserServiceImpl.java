package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.User;
import com.yannyao.blog.mapper.UserMapper;
import com.yannyao.blog.service.UserService;
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
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getList() throws Exception{
        List<User> userList = new ArrayList<>();
        try {
            userList = userMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userList;
    }
    @Override
    public BaseTableMessage getList(int page, int limit) throws Exception {
        List<User> userList = new ArrayList<>();
        BaseTableMessage tableMessage = new BaseTableMessage();
        try {
            tableMessage.setLimit(limit);
            tableMessage.setOffset((page-1)*limit);
            userList = userMapper.getList(tableMessage);
            tableMessage.setRows(userList);
            tableMessage.setTotal(userMapper.getAllCount());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return tableMessage;
    }
    @Override
    public User getById(Integer id) throws Exception{
        User user = new User();
        try {
            user = userMapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
    @Override
    public User getByUsername(String username) throws Exception{
        User user = new User();
        try {
            user = userMapper.getByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
    @Override
    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) {
        return null;
    }

    @Override
    public boolean add(User user) {

        boolean state = false;
        try {
            state = userMapper.insert(user) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean update(User user) {
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
    public boolean validate(User user) {
        return false;
    }
}
