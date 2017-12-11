package com.yannyao.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.demo.config.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description:文章标签
 * @Date Created in 13:05 2017/12/11
 */
@Data
@AllArgsConstructor
public class ArticleTag {
    private Integer tagId;

    private String tagName;
    /**
     * 状态0为启用，1为禁用
     */
    private Integer tagStatus;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;

}
