package com.yannyao.blog.common.module.vo;

import com.yannyao.blog.bean.Category;
import com.yannyao.blog.bean.Tag;
import com.yannyao.blog.common.module.dto.BaseDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 16:09
 * @Description:
 */
@Data
@Accessors(chain = true)
public class ArticleVO extends BaseDTO {
    private String title;

    private String description;

    private Integer adminId;

    private String image;

    private Integer click;

    private Integer like;

    private Integer dislike;

    private Integer commentCount;

    private Integer commend;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String content;

    private List<Tag> tagList;

    private List<Category> categoryList;
}
