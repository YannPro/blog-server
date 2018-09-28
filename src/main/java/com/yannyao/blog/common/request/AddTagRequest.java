package com.yannyao.blog.common.request;

import com.yannyao.blog.common.module.dto.TagDTO;
import com.yannyao.blog.common.validation.ParamNotNull;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
@Data
public class AddTagRequest {
    @ParamNotNull("标签")
    private List<TagDTO> tagList;
}
