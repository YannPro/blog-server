package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleTableMessage;
import com.yannyao.blog.bean.BaseTableMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 查询所有文章列表
     * @return文章列表
     * @throws Exception
     */
    public List<Article> getAll() throws Exception;
    /**
     * 查询所有文章数
     * @return文章数
     * @throws Exception
     */
    public Integer getAllCount() throws Exception;

    /**
     * 根据主键获取文章
     * @param id
     * @return
     * @throws Exception
     */
    public Article getById(Integer id) throws Exception;

    /**
     * 根据TableMessage和文章组别查询文章
     * @param tableMessage
     * @return
     */
    public List<Article> getList(BaseTableMessage tableMessage) throws Exception;

    /**
     * 根据TableMessage获取查询到的文章数量
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public Integer searchArticleCount(ArticleTableMessage tableMessage) throws Exception;

    /**
     * 新增一个文章
     * @param article
     * @return
     */
    public int insert(Article article) throws Exception;

    /**
     * 修改一个文章
     */
    public int update(Article article) throws Exception;

    /**
     * 删除一个文章
     */
    public int delete(Integer id) throws Exception;

}
