package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.Comment;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.common.request.IdRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.common.response.PageResponse;
import com.yannyao.blog.service.Impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    @ResponseBody
    public PageResponse<Comment> listArticleComment(IdRequest request){
        return commentService.listArticleComment(request);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message delete(@PathVariable(value = "id") Integer id){
    return null;
    }
}
