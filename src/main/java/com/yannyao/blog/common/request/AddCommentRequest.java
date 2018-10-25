package com.yannyao.blog.common.request;

import com.yannyao.blog.common.validation.ParamNotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
@Data
@Accessors(chain = true)
public class AddCommentRequest {

    private Integer articleId;

    private Integer userId;

    private Integer replyUserId;

    private Integer parentCommentId;

    private String content;

    private Integer type;

}
