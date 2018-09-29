package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Comment;
import com.yannyao.blog.bean.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommentMapper extends BaseMapper<Comment, CommentExample> {
}