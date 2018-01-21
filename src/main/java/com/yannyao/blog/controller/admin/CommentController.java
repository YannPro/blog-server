package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.ArticleComment;
import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.service.ArticleService;
import com.yannyao.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Message getList(@RequestParam("page") int page,
                           @RequestParam("limit") int limit){
        List<ArticleComment> commentList = new ArrayList<>();
        try {
            commentList = commentService.getList(page,limit);
            return new Message(Message.SUCCESS,"获取文章评论成功！",commentList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取文章评论失败！",null);
        }
    }

}
