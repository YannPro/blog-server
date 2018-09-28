package com.yannyao.blog.common.request;

import lombok.Data;

import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
@Data
public class IdsRequest {
    private List<Long> ids;
}
