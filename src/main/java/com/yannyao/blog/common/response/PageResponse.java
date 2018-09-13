package com.yannyao.blog.common.response;

import lombok.Data;

import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:05
 * @Description:
 */
@Data
public class PageResponse<T> extends BaseResponse<List<T>> {

    private int size;

    private int total;

    private int pageNo;

    private int pageSize = 10;

}