package com.yannyao.blog.common.request;

import lombok.Data;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:05
 * @Description:
 */
@Data
public class PageRequest {

    private int pageNo = 1;

    private int pageSize = 10;
    
}
