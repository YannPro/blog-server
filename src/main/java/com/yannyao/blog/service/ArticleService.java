package com.yannyao.blog.service;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleTableMessage;
import com.yannyao.blog.bean.BaseTableMessage;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
public interface ArticleService {
    /**
     * 获取文章列表
     * @return
     * @throws Exception
     */
    public List<Article> getAll() throws Exception;

    /**
     * 获取文章列表
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    public BaseTableMessage getList(int page, int limit) throws Exception;
    /**
     * 根据id获取文章
     * @param id
     * @return
     * @throws Exception
     */
    public Article getById(Integer id) throws Exception;

    /**
     * 根据TableMessage获取查询到的文章
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception;
    /**
     * 新增一个文章
     * @param article
     * @return
     * @throws Exception
     */
    public Article add(Article article) throws Exception;
    /**
     * 修改一个文章
     * @param article
     * @return
     * @throws Exception
     */
    public Article update(Article article) throws Exception;

    /**
     * 删除一个文章
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception;

}
