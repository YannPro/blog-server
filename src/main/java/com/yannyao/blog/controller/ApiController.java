//package com.yannyao.blog.controller;
//
//import com.yannyao.blog.bean.ArticleClass;
//import com.yannyao.blog.bean.ArticleComment;
//import com.yannyao.blog.bean.ArticleTag;
//import com.yannyao.blog.bean.Message;
//import com.yannyao.blog.service.ArticleService;
//import com.yannyao.blog.service.ClassService;
//import com.yannyao.blog.service.CommentService;
//import com.yannyao.blog.service.TagService;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: YannYao
// * @Description:
// * @Date Created in 10:29 2018/1/4
// */
//@RestController
//@RequestMapping("/api")
//@Api
//public class ApiController {
//    @Autowired
//    private ArticleService articleService;
//    @Autowired
//    private CommentService commentService;
//    @Autowired
//    private ClassService classService;
//    @Autowired
//    private TagService tagService;
//
//    /**
//     * 查询一篇文章的所有评论
//     * @param id
//     * @param limit
//     * @param page
//     * @return
//     */
//    @RequestMapping(value = "/article/{id}/comment", method = RequestMethod.GET)
//    @ResponseBody
//    public Message commentList(@PathVariable(value = "id") Integer id,
//                               @RequestParam("limit") int limit,
//                               @RequestParam("page") int page){
//        List<ArticleComment> commentList = new ArrayList<>();
//        try {
//            commentList = commentService.getListByArticleId(id,page,limit);
//            return new Message(Message.SUCCESS,"获取文章评论成功！",commentList);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"获取文章评论失败！",null);
//        }
//    }
//
//    /**
//     * 新增文章评论
//     * @param comment
//     * @return
//     */
//    @RequestMapping(value = "/comment", method = RequestMethod.POST)
//    @ResponseBody
//    public Message add(@RequestBody ArticleComment comment){
//        try {
//            ArticleComment result = commentService.add(comment);
//            if(result.getId() > 0){
//                return new Message(Message.SUCCESS,"新增文章评论成功！",result);
//            }else{
//                return new Message(Message.ERROR,"新增文章评论失败！",null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"新增文章评论失败！",null);
//        }
//    }
//
//    /**
//     * 获取类别列表
//     * @return
//     */
//    @RequestMapping(value = "/class/all", method = RequestMethod.GET)
//    @ResponseBody
//    public Message getClassList(){
//
//        List<ArticleClass> classList = new ArrayList<>();
//
//        try {
//            classList = classService.getList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"获取类别列表失败！",null);
//        }
//        return new Message(Message.SUCCESS,"获取类别列表成功！",classList);
//    }
//
//    /**
//     * 获取标签列表
//     * @return
//     */
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    @ResponseBody
//    public Message getTagList(){
//
//        List<ArticleTag> tagList = new ArrayList<>();
//
//        try {
//            tagList = tagService.getList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"获取标签列表失败！",null);
//        }
//        return new Message(Message.SUCCESS,"获取标签列表成功！",tagList);
//    }
//
//}
