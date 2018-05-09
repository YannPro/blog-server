package com.yannyao.blog.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.blog.config.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:03 2017/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;

    private String title;

    private String description;

    private String content;
    /**
     * 添加文章的管理员
     * */
    private Integer adminId;

    private String image;

    /**
     * article点击数
     */
    private Integer click;

    private Integer like;

    private Integer dislike;

    private Integer commentCount;
    /**
     * 文章所属类目
     */
    private Integer clazz;
    /**
     * 是否推荐：0.不推荐，1.推荐到首页
     */
    private Integer commend;
    /**
     * 状态，0为显示，1为隐藏，3为删除
     */
    private Integer status;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;

    private ArticleClass articleClass;
    /**
     * article所属标签数组
     * */
    private List<ArticleTag> tagList;
}
