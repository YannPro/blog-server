package com.yannyao.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.demo.config.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:03 2017/12/11
 */
@Data
@AllArgsConstructor
public class Article {
    private Integer articleId;

    private String articleTitle;

    private String articleContent;
    /**
     * 添加文章的管理员
     * */
    private String articleAdmin;

    private String articleImage;
    /**
     * article和article_tag关系表的id
     * */
    private String articleTagRid;
    /**
     * article所属标签数组
     */
    private List<ArticleTag> list;
    /**
     * article点击数
     */
    private Integer articleClick;

    private Integer articleLike;

    private Integer articleDislike;

    private Integer articleCommentCount;
    /**
     * 文章所属类目
     */
    private Integer articleClass;
    /**
     * 是否推荐：0.不推荐，1.推荐到首页
     */
    private Integer articleCommend;
    /**
     * 状态，0为显示，1为隐藏，3为删除
     */
    private Integer articleStatus;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;
}
