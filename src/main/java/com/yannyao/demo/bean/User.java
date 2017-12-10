package com.yannyao.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.demo.config.CustomJsonDateDeserializer;
import lombok.Data;

import java.util.Date;

/**
 * @author YannYao
 * @create 2017-12-10 16:59
 **/
@Data
public class User {
    private Integer userId;

    private String username;

    private String password;

    private String nickname;

    private String email;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;
}
