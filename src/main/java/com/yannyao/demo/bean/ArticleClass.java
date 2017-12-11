package com.yannyao.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yannyao.demo.config.CustomJsonDateDeserializer;
import lombok.Data;

import java.util.Date;

/**
 * @Author: YannYao
 * @Description: 文章类目
 * @Date Created in 13:03 2017/12/11
 */
@Data
public class ArticleClass {
    private Integer classId;

    private String className;
    /**
     * 状态0为启用，1为禁用
     */
    private Integer classStatus;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updateTime;

}
