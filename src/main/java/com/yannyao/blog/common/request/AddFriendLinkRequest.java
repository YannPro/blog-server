package com.yannyao.blog.common.request;

import com.yannyao.blog.common.validation.ParamNotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
@Data
@Accessors(chain = true)
public class AddFriendLinkRequest {

    private String logo;

    @ParamNotNull("名称")
    private String name;

    @ParamNotNull("url")
    private String url;

    @ParamNotNull("排序")
    private Integer seqId;

}
