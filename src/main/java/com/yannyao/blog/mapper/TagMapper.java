package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.ArticleTag;
import com.yannyao.blog.bean.ArticleTag;
import com.yannyao.blog.bean.BaseTableMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {

    /**
     * 查询所有文章标签列表
     * @return文章标签列表
     * @throws Exception
     */
    public List<ArticleTag> getList() throws Exception;

    /**
     * 通过文章id获取标签列表
     * @return文章标签列表
     * @throws Exception
     */
    public List<ArticleTag> getListByArticleId(Integer articleId) throws Exception;

    /**
     * 新增一个文章标签
     * @param articleTag
     * @return
     */

    public int insert(ArticleTag articleTag) throws Exception;
    /**
     * 根据主键获取类别
     * @param id
     * @return
     * @throws Exception
     */
    public ArticleTag getById(Integer id) throws Exception;

    /**
     * 修改一个文章标签
     */

    public int delete(Integer id) throws Exception;

}
