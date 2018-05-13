package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.TRArticleTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TRArticleTagMapper {

    /**
     * 查询所有文章标签关系列表
     * @return文章标签关系列表
     * @throws Exception
     */
    public List<TRArticleTag> getList() throws Exception;

    /**
     * 新增一个文章标签关系
     * @param trArticleTag
     * @return
     */

    public int insert(TRArticleTag trArticleTag) throws Exception;

    /**
     * 修改一个文章标签关系
     */
    public int delete(Integer id) throws Exception;

}
