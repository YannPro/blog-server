package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.User;
import com.yannyao.blog.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper extends BaseMapper<User, UserExample> {
}