package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleComment;
import com.yannyao.blog.bean.ArticleTableMessage;
import com.yannyao.blog.bean.BaseTableMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 查询所有文章评论列表
     * @return文章评论列表
     * @throws Exception
     */
    public List<ArticleComment> getAll() throws Exception;

    /**
     * 根据主键获取文章评论
     * @param id
     * @return
     * @throws Exception
     */
    public ArticleComment getById(Integer id) throws Exception;

    /**
     * 根据TableMessage和文章评论组别查询文章评论
     * @param tableMessage
     * @return
     */
    public List<ArticleComment> getList(BaseTableMessage tableMessage) throws Exception;
    /**
     * 根据TableMessage和文章id查询文章评论
     * @param tableMessage
     * @return
     */
    public List<ArticleComment> getListByArticleId(@Param("articleId") Integer id ,@Param("tableMessage") BaseTableMessage tableMessage) throws Exception;

    /**
     * 根据TableMessage获取查询到的文章评论数量
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public Integer searchArticleCount(ArticleTableMessage tableMessage) throws Exception;

    /**
     * 新增一个文章评论
     * @param comment
     * @return
     */
    public int insert(ArticleComment comment) throws Exception;

    /**
     * 修改一个文章评论
     */
    public int update(Article article) throws Exception;

    /**
     * 删除一个文章评论
     */
    public int delete(Integer id) throws Exception;

}
