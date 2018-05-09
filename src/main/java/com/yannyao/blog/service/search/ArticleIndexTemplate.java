package com.yannyao.blog.service.search;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleIndexTemplate {

    private Integer id;

    private String title;

    private String description;

    private String content;

    private Integer adminId;

    private String image;

    private Integer click;

    private Integer like;

    private Integer dislike;

    private Integer commentCount;

    private Integer clazz;

    private Integer commend;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}
