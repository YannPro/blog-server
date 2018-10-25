package com.yannyao.blog.common.module.vo;

import com.yannyao.blog.bean.BaseBean;
import com.yannyao.blog.bean.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class CommentVO extends BaseBean {

    private Integer articleId;

    private Integer userId;

    private Integer parentCommentId;

    private Integer replyUserId;

    private String content;

    private String ip;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer type;

    private User user;

    private User replyUser;
}