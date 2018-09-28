package com.yannyao.blog.common.request;

import com.yannyao.blog.common.module.dto.CategoryDTO;
import com.yannyao.blog.common.module.dto.TagDTO;
import com.yannyao.blog.common.validation.ParamNotNull;
import lombok.Data;

import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
@Data
public class AddCategoryRequest {
    @ParamNotNull("类目")
    private List<CategoryDTO> categoryList;
}
