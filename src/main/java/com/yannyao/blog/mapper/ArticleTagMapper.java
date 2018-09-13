package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.ArticleTag;
import com.yannyao.blog.bean.ArticleTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticleTagMapper extends BaseMapper<ArticleTag, ArticleTagExample> {
}