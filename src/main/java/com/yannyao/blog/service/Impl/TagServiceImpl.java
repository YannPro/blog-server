//package com.yannyao.blog.service.Impl;
//
//import com.yannyao.blog.bean.ArticleTag;
//import com.yannyao.blog.bean.BaseTableMessage;
//import com.yannyao.blog.mapper.TagMapper;
//import com.yannyao.blog.service.TagService;
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
//public class TagServiceImpl implements TagService{
//    @Autowired
//    private TagMapper tagMapper;
//    @Override
//    public List<ArticleTag> getList() {
//        List<ArticleTag> tagList = new ArrayList<>();
//        try {
//            tagList = tagMapper.getList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return tagList;
//    }
//
////    public List<ArticleTag> getListByArticleId() {
////        List<ArticleTag> tagList = new ArrayList<>();
////        try {
////            tagList = tagMapper.getListByArticleId();
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
////        return tagList;
////    }
//
//    @Override
//    public boolean add(ArticleTag tag) {
//
//        boolean state = false;
//        try {
//            state = tagMapper.insert(tag) == 1 ? true : false;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return state;
//    }
//
//
//    @Override
//    public boolean delete(Integer id) {
//        boolean state = false;
//        try {
//            state = tagMapper.delete(id) == 1 ? true : false;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return state;
//    }
//
//}
