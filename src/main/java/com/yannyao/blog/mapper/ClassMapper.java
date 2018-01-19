package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleClass;
import com.yannyao.blog.bean.BaseTableMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    /**
     * 查询所有文章类别列表
     * @return文章类别列表
     * @throws Exception
     */
    public List<ArticleClass> getList() throws Exception;

    /**
     * 新增一个文章类别
     * @param clazz
     * @return
     */
    public int insert(ArticleClass clazz) throws Exception;
    /**
     * 根据主键获取类别
     * @param id
     * @return
     * @throws Exception
     */
    public ArticleClass getById(Integer id) throws Exception;

    /**
     * 修改一个文章类别
     */
    public int update(ArticleClass clazz) throws Exception;

    /**
     * 修改一个文章类别
     */
    public int delete(Integer id) throws Exception;

}
