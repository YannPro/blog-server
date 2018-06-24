package com.yannyao.blog.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.blog.config.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description:文章标签
 * @Date Created in 13:05 2017/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTag {
    private Integer id;

    private String tagName;
    /**
     * 状态0为启用，1为禁用
     */
    private Integer status;

//    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

//    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;

}
