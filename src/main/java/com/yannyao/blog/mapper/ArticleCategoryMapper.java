package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.ArticleCategory;
import com.yannyao.blog.bean.ArticleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory, ArticleCategoryExample> {
}