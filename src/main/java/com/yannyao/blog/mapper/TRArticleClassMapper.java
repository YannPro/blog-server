package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.TRArticleClass;
import com.yannyao.blog.bean.TRArticleTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TRArticleClassMapper {

    /**
     * 查询所有文章类别关系列表
     * @return文章类别关系列表
     * @throws Exception
     */
    public List<TRArticleClass> getList() throws Exception;

    /**
     * 新增一个文章类别关系
     * @param trArticleClass
     * @return
     */

    public int insert(TRArticleClass trArticleClass) throws Exception;

    /**
     * 修改一个文章类别关系
     */
    public int delete(Integer id) throws Exception;

}
