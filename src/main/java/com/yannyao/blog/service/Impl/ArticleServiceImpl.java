package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.*;
import com.yannyao.blog.mapper.ArticleMapper;
import com.yannyao.blog.mapper.ClassMapper;
import com.yannyao.blog.mapper.TagMapper;
import com.yannyao.blog.service.ArticleService;
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
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Article> getList(Integer page,Integer limit) throws Exception {
        List<Article> articleList = new ArrayList<>();
        List<ArticleTag> tagList = new ArrayList<>();
        ArticleClass articleClass = new ArticleClass();
        try {

            articleList = articleMapper.getList(page, limit);
            for (Article article: articleList){

                Integer id = article.getId();
                Integer clazz = article.getClazz();
                //todo
                //通过文章id获取她的标签列表
                article.setTagList(tagMapper.getListByArticleId(id));
                article.setArticleClass(classMapper.getById(clazz));

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return articleList;
    }

    @Override
    public Article getById(Integer id) {
        Article article = new Article();
        try {
            article = articleMapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return article;
    }

    @Override
    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception {
        return null;
    }


    @Override
    public boolean add(Article article) {

        boolean state = false;
        try {
            state = articleMapper.insert(article) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean update(Article article) {
        boolean state = false;
        try {
            state = articleMapper.update(article) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public boolean delete(Integer id) {
        boolean state = false;
        try {
            state = articleMapper.delete(id) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

}
