package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.ArticleTag;
import com.yannyao.blog.bean.ArticleTagExample;
import com.yannyao.blog.bean.Tag;
import com.yannyao.blog.bean.TagExample;
import com.yannyao.blog.mapper.ArticleTagMapper;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class ArticleTagService extends BaseService<ArticleTag, ArticleTagExample>{

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    BaseMapper<ArticleTag, ArticleTagExample> mapper() {
        return articleTagMapper;
    }

}
