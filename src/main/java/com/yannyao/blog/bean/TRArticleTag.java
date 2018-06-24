package com.yannyao.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TRArticleTag {
    private Integer id;

    private Integer articleId;

    private Integer tagId;
}
