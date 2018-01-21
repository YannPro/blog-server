package com.yannyao.blog.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.blog.config.CustomJsonDateDeserializer;
import lombok.Data;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:03 2017/12/11
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String avatarImage;
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;
}
