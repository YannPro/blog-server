package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.ArticleCategory;
import com.yannyao.blog.bean.ArticleCategoryExample;
import com.yannyao.blog.bean.ArticleTag;
import com.yannyao.blog.bean.ArticleTagExample;
import com.yannyao.blog.mapper.ArticleCategoryMapper;
import com.yannyao.blog.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class ArticleCategoryService extends BaseService<ArticleCategory, ArticleCategoryExample>{

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;
    @Override
    BaseMapper<ArticleCategory, ArticleCategoryExample> mapper() {
        return articleCategoryMapper;
    }
}
