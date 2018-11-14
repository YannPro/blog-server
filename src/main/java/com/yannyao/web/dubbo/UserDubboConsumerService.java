package com.yannyao.web.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yannyao.blog.bean.User;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class UserDubboConsumerService {

    @Reference(version = "1.0.0")
    UserDubboService userDubboService;

    public void printCity() {
        User user = userDubboService.findByName("dddd");
        System.out.println("!!!!!!!!!!dubbo!!!!!!!!"+user.toString());
    }
}
