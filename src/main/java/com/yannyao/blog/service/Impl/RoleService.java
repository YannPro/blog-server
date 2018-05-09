package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.Role;
import com.yannyao.blog.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getByMap(Map<String,Object> map) {
        return roleMapper.getByMap(map);
    }

    public Role getById(Integer id) {
        return roleMapper.getById(id);
    }

    public Role create(Role role) {
        roleMapper.create(role);
        return role;
    }

    public Role update(Role role) {
        roleMapper.update(role);
        return role;
    }

    public int delete(Integer id) {
        return roleMapper.delete(id);
    }

}