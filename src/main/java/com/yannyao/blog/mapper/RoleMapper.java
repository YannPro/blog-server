package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    List<Role> getByMap(Map<String, Object> map);
    Role getById(Integer id);
    Integer create(Role role);
    int update(Role role);
    int delete(Integer id);
}