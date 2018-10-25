package com.yannyao.blog.controller;

import com.yannyao.blog.bean.Category;
import com.yannyao.blog.bean.Tag;
import com.yannyao.blog.common.module.vo.CommentVO;
import com.yannyao.blog.common.request.AddCommentRequest;
import com.yannyao.blog.common.request.IdRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.service.Impl.CategoryService;
import com.yannyao.blog.service.Impl.CommentService;
import com.yannyao.blog.service.Impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 10:29 2018/1/4
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询一篇文章的所有评论
     * @param id
     * @return
     */
    @GetMapping(value = "/article/{id}/comment")
    @ResponseBody
    public BaseResponse<List<CommentVO>> listCommentByArticleId(@PathVariable(value = "id") Integer id){
        return commentService.listArticleComment(new IdRequest(id));
    }

    /**
     * 新增文章评论
     * @param request
     * @return
     */
    @PostMapping(value = "/comment")
    @ResponseBody
    public BaseResponse add(@RequestBody AddCommentRequest request){
        return commentService.addComment(request);
    }

    @GetMapping("/tag/all")
    @ResponseBody
    public BaseResponse<List<Tag>> listTag(){
        return tagService.listTag();
    }

    @GetMapping("/category/all")
    @ResponseBody
    public BaseResponse<List<Category>> listCategory(){
        return categoryService.listCategory();
    }

}
