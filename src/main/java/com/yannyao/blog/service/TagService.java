package com.yannyao.blog.service;

import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.ArticleTag;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
public interface TagService {
    /**
     * 获取标签列表
     * @return
     * @throws Exception
     */
    public List<ArticleTag> getList() throws Exception;

    /**
     * 新增一个标签
     * @param tag
     * @return
     * @throws Exception
     */
    public boolean add(ArticleTag tag) throws Exception;

    /**
     * 删除一个标签
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception;
    
}
