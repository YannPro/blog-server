package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.Comment;
import com.yannyao.blog.bean.CommentExample;
import com.yannyao.blog.common.exception.BaseErrors;
import com.yannyao.blog.common.exception.BusinessException;
import com.yannyao.blog.common.module.vo.CommentVO;
import com.yannyao.blog.common.request.AddCommentRequest;
import com.yannyao.blog.common.request.IdRequest;
import com.yannyao.blog.common.request.ListCommentRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.common.response.PageResponse;
import com.yannyao.blog.common.util.ObjectUtil;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.CommentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class CommentService extends BaseService<Comment, CommentExample>{

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;
    @Override
    BaseMapper<Comment, CommentExample> mapper() {
        return commentMapper;
    }

    /**
     * 获取一篇文章的评论
     * @param request
     * @return
     */
    public PageResponse<CommentVO> listArticleComment (IdRequest request) {
        if (ObjectUtil.isEmpty(request.getId())) {
            throw new BusinessException("文章主键不能为空", BaseErrors.REQUEST_PARAM_ERROR);
        }
        List<CommentVO> commentVOList = new ArrayList<>();

        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andArticleIdEqualTo(request.getId())
                                        .andTypeEqualTo(0);
        List<Comment> commentList = mapper().selectByExample(commentExample);
        commentList.forEach(comment -> {
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(comment, commentVO);
            if (comment.getReplyUserId() != null) {
                commentVO.setReplyUser(userService.getUser(comment.getReplyUserId()).getData());
            }
            commentVO.setUser(userService.getUser(comment.getUserId()).getData());
            commentVOList.add(commentVO);
        });

        PageResponse<CommentVO> response = new PageResponse<>();
        response.setData(commentVOList);
        return response;
    }

    /**
     * 获取评论列表 根据时间排序
     * @param request
     * @return
     */
    public PageResponse<CommentVO> listComment (ListCommentRequest request) {
        List<CommentVO> commentVOList = new ArrayList<>();
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andTypeEqualTo(0);
        commentExample.setOrderByClause("create_time desc");
        List<Comment> commentList = mapper().selectByExample(commentExample);
        commentList.forEach(comment -> {
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(comment, commentVO);
            if (comment.getReplyUserId() != null) {
                commentVO.setReplyUser(userService.getUser(comment.getReplyUserId()).getData());
            }
            commentVO.setUser(userService.getUser(comment.getUserId()).getData());
            commentVOList.add(commentVO);
        });

        PageResponse<CommentVO> response = new PageResponse<>();
        response.setData(commentVOList);
        return response;
    }
    @Transactional
    public BaseResponse addComment (AddCommentRequest request) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(request, comment);
        insertSelective(comment);
        return new BaseResponse();
    }

    @Transactional
    public BaseResponse deleteComment (Integer id) {
        mapper().deleteByPrimaryKey(id);
        return new BaseResponse();
    }
}
