package com.yannyao.blog.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.blog.config.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description:友链
 * @Date Created in 13:05 2018/1/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLink {
    private Integer id;

    private String linkName;

    private String url;

    private Integer adminId;
    /**
     * 状态0为启用，1为禁用
     */
    private Integer status;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;

}
