package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.*;
import com.yannyao.blog.mapper.ArticleMapper;
import com.yannyao.blog.mapper.ClassMapper;
import com.yannyao.blog.mapper.TagMapper;
import com.yannyao.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Override
    public List<Article> getAll() throws Exception {
        List<Article> articleList = new ArrayList<>();
        List<ArticleTag> tagList = new ArrayList<>();
        ArticleClass articleClass = new ArticleClass();
        try {

            articleList = articleMapper.getAll();
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
    public List<Article> getList(int page, int limit) throws Exception {
        List<Article> articleList = new ArrayList<>();
        List<ArticleTag> tagList = new ArrayList<>();
        ArticleClass articleClass = new ArticleClass();
        BaseTableMessage tableMessage = new BaseTableMessage();
        try {
            tableMessage.setLimit(limit);
            tableMessage.setOffset((page-1)*limit);
            articleList = articleMapper.getList(tableMessage);
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
            Integer clazz = article.getClazz();
            article.setTagList(tagMapper.getListByArticleId(id));
            article.setArticleClass(classMapper.getById(clazz));
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
    public Article add(Article article) {
        Article result = null;
        try {
            articleMapper.insert(article);
            result = articleMapper.getById(article.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Article update(Article article) {
        Article result = null;
        try {
            int row = articleMapper.update(article);
            if(row >= 1){
                result = articleMapper.getById(article.getId());
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
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
