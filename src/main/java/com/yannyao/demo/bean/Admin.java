package com.yannyao.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.demo.config.CustomJsonDateDeserializer;
import lombok.Data;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:03 2017/12/11
 */
@Data
public class Admin {
    private Integer adminId;

    private String adminName;

    private String password;

    private String email;
    /*所在权限组*/
    private Integer adminGroup;
    /*状态0为允许登录，1为禁止登录*/
    private Integer status = 0;

    private String ip = "0.0.0.0";
    /*登录地址*/
    private String ipAddress;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;
}
