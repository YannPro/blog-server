package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.User;
import com.yannyao.blog.bean.UserExample;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class UserService extends BaseService<User, UserExample>{

    @Autowired
    private UserMapper userMapper;

    @Override
    BaseMapper<User, UserExample> mapper() {
        return userMapper;
    }

//    public BaseResponse<List<User>> listUser () {
//        BaseResponse<List<User>> response = new BaseResponse<>();
//        List<User> userList = listByExample(new UserExample(), 1, 1000);
//        return response.setData(userList);
//    }
    public BaseResponse<User> getUser (Integer userId) {
        BaseResponse<User> response = new BaseResponse<>();
        User user = userMapper.selectByPrimaryKey(userId);
        return response.setData(user);
    }
//    @Transactional
//    public BaseResponse addUser (AddUserRequest request) {
//        List<UserDTO> userDTOList = request.getUserList();
//        userDTOList.forEach(userDTO -> {
//            User user = new User();
//            BeanUtils.copyProperties(userDTO, user);
//            mapper().insertSelective(user);
//        });
//        return new BaseResponse();
//    }
//
//    @Transactional
//    public BaseResponse deleteUser (Integer id) {
//        mapper().deleteByPrimaryKey(id);
//        return new BaseResponse();
//    }
}
