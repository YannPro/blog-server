package com.yannyao.blog.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.blog.config.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description: 文章类目
 * @Date Created in 13:03 2017/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleClass {
    private Integer id;

    private String className;
    /**
     * 状态0为启用，1为禁用
     */
    private Integer status;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;

}
