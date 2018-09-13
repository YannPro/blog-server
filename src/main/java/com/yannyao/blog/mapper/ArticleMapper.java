package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticleMapper extends BaseMapper<Article, ArticleExample> {
}