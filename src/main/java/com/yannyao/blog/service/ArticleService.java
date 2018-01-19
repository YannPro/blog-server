package com.yannyao.blog.service;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleTableMessage;
import com.yannyao.blog.bean.BaseTableMessage;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
public interface ArticleService {
    /**
     * 获取管理员列表
     * @return
     * @throws Exception
     */
    public List<Article> getList(Integer page,Integer limit) throws Exception;

    /**
     * 根据id获取管理员
     * @param id
     * @return
     * @throws Exception
     */
    public Article getById(Integer id) throws Exception;

    /**
     * 根据TableMessage获取查询到的管理员
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception;
    /**
     * 新增一个管理员
     * @param article
     * @return
     * @throws Exception
     */
    public boolean add(Article article) throws Exception;
    /**
     * 修改一个管理员
     * @param article
     * @return
     * @throws Exception
     */
    public boolean update(Article article) throws Exception;

    /**
     * 删除一个管理员
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception;

}
