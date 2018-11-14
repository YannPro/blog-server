package com.yannyao.web.dubbo;


import com.yannyao.blog.bean.User;

/**
 * 城市业务 Dubbo 服务层
 *
 * Created by bysocket on 28/02/2017.
 */
public interface UserDubboService {
    User findByName(String name);
}
