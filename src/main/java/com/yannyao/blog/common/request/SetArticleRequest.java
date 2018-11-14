package com.yannyao.blog.common.request;

import com.yannyao.blog.bean.Category;
import com.yannyao.blog.bean.Tag;
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
public class SetArticleRequest {

    private Integer id;

    private String title;

    private String description;

    private Integer adminId;

    private String image;

    private Integer commend;

    private Integer status;

    private String content;

    private List<Tag> tagList;

    private List<Category> categoryList;
}
