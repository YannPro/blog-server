package com.yannyao.blog.service;

import com.yannyao.blog.bean.ArticleClass;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
public interface ClassService {
    /**
     * 获取标签列表
     * @return
     * @throws Exception
     */
    public List<ArticleClass> getList() throws Exception;

    /**
     * 新增一个标签
     * @param clazz
     * @return
     * @throws Exception
     */
    public boolean add(ArticleClass clazz) throws Exception;

    /**
     * 删除一个标签
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception;
    
}
