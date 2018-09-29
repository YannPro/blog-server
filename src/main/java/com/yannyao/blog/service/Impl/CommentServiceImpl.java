//package com.yannyao.blog.service.Impl;
//
//import com.yannyao.blog.bean.*;
//import com.yannyao.blog.mapper.*;
//import com.yannyao.blog.service.ArticleService;
//import com.yannyao.blog.service.CommentService;
//import com.yannyao.blog.util.CommonUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: YannYao
// * @Description:
// * @Date Created in 13:44 2017/12/11
// */
//@Component
//public class CommentServiceImpl implements CommentService{
//    @Autowired
//    private CommentMapper commentMapper;
//    @Autowired
//    private UserMapper userMapper;
//    private final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
////    @Override
////    public List<ArticleComment> getAll() throws Exception {
////        List<Article> articleList = new ArrayList<>();
////        List<ArticleTag> tagList = new ArrayList<>();
////        ArticleClass articleClass = new ArticleClass();
////        try {
////
////            articleList = articleMapper.getAll();
////            for (Article article: articleList){
////
////                Integer id = article.getId();
////                Integer clazz = article.getClazz();
////                //todo
////                //通过文章id获取她的标签列表
////                article.setTagList(tagMapper.getListByArticleId(id));
////                article.setArticleClass(classMapper.getById(clazz));
////
////            }
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
////        return articleList;
////    }
//
//
//    @Override
//    public List<ArticleComment> getList(int page, int limit) {
//        List<ArticleComment> commentList = new ArrayList<>();
//        BaseTableMessage tableMessage = new BaseTableMessage();
//        try {
//            tableMessage.setLimit(limit);
//            tableMessage.setOffset((page-1)*limit);
//            commentList = commentMapper.getList(tableMessage);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return commentList;
//    }
//
//    @Override
//    public List<ArticleComment> getListByArticleId(Integer id, int page, int limit) {
//        List<ArticleComment> commentList = new ArrayList<>();
//        BaseTableMessage tableMessage = new BaseTableMessage();
//        try {
//            tableMessage.setLimit(limit);
//            tableMessage.setOffset((page-1)*limit);
//            commentList = commentMapper.getListByArticleId(id, tableMessage);
//            for (ArticleComment comment: commentList){
//                Integer userId = comment.getUserId(), replyUserId = comment.getReplyUserId();
//                if (userId!=null){
//                    comment.setUser(userMapper.getById(userId));
//                }
//                if (replyUserId!=null) {
//                    comment.setReplyUser(userMapper.getById(comment.getReplyUserId()));
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return commentList;
//    }
//    @Override
//    public ArticleComment add(ArticleComment comment) {
//        ArticleComment result = null;
//        try {
//            commentMapper.insert(comment);
//            result = commentMapper.getById(comment.getId());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
//    @Override
//    public boolean delete(Integer id) {
//        boolean state = false;
//        try {
//            state = commentMapper.delete(id) == 1 ? true : false;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return state;
//    }
////
////    @Override
////    public Article getById(Integer id) {
////        Article article = new Article();
////        try {
////            article = articleMapper.getById(id);
////            Integer clazz = article.getClazz();
////            article.setTagList(tagMapper.getListByArticleId(id));
////            article.setArticleClass(classMapper.getById(clazz));
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
////        return article;
////    }
////
////    @Override
////    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception {
////        return null;
////    }
////
//
////
////    @Override
////    public Article update(ArticleComment comment) throws Exception {
////        return null;
////    }
////
////
////    @Override
////    public Article add(Article article) {
////        Article result = null;
////        try {
////            articleMapper.insert(article);
////            result = articleMapper.getById(article.getId());
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return result;
////    }
////
////    @Override
////    public Article update(Article article) {
////        Article result = null;
////        try {
////            int row = articleMapper.update(article);
////            if(row >= 1){
////                result = articleMapper.getById(article.getId());
////            }else{
////                return null;
////            }
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return result;
////    }
////
//
//
//}
