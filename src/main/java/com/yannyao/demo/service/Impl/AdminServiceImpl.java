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
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> getList() {
        List<Admin> adminList = new ArrayList<>();
        try {
            adminList = adminMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return adminList;
    }

    @Override
    public Admin getById(Integer id) {
        Admin admin = new Admin();
        try {
            admin = adminMapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return admin;
    }

    @Override
    public AdminTableMessage search(AdminTableMessage tableMessage) {
        return null;
    }

    @Override
    public boolean add(Admin admin) {
        return false;
    }

    @Override
    public boolean update(Admin user) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean validate(Admin user) {
        return false;
    }
}
