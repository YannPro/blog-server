package com.yannyao.blog.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.blog.config.CustomJsonDateDeserializer;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:03 2018/1/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleComment {
    private Integer id;

    private String content;

    /**
     * 在哪篇文章下评论
     * */
    private Integer articleId;
    /**
     * 评论者用户id
     * */
    private Integer userId;

    /**
     * 父级评论id
     * */
    private Integer parentCommentId;

    /**
     * 回复哪个评论者的id
     */
    private Integer replyUserId;

    /**
     * 状态，0为启用 1为删除
     */
    private Integer status;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    ////////////
    private User user;

    private User replyUser;
}
