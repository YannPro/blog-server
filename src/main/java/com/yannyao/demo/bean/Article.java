package com.yannyao.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.demo.config.CustomJsonDateDeserializer;

import java.util.Date;

/**
 * @author YannYao
 * @create 2017-12-10 17:17
 **/
public class Article {
    private Integer articleId;

    private String articleTitle;

    private String articleContent;
    /*添加文章的管理员*/
    private String articleAdmin;

    private String articleImage;

    private String email;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;
}
