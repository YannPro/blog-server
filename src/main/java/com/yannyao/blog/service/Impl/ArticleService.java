package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.*;
import com.yannyao.blog.common.module.vo.ArticleVO;
import com.yannyao.blog.common.request.ListArticleRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.common.response.PageResponse;
import com.yannyao.blog.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class ArticleService extends BaseService<Article, ArticleExample>{

    private final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Autowired
    private CategoryService categoryService;

    public List<Article> getAll() throws Exception {
        List<Article> articleList = new ArrayList<>();
        List<ArticleTag> tagList = new ArrayList<>();
        ArticleClass articleClass = new ArticleClass();
        try {

//            articleList = articleMapper.getAll();
//            for (Article article: articleList){
//
//                Integer id = article.getId();
//                //todo
//                //通过文章id获取她的标签列表
//                article.setTagList(tagMapper.getListByArticleId(id));
//                article.setClassList(classMapper.getListByArticleId(id));
//
//            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return articleList;
    }

    public PageResponse<ArticleVO> listArticle(ListArticleRequest request) {
        PageResponse<ArticleVO> response = new PageResponse<>();
        List<ArticleVO> articleVOList = new ArrayList<>();
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("create_time desc");
        List<Article> articleList = listByExample(articleExample, request.getPageNo(), request.getPageSize());
        for (Article article: articleList){
            ArticleVO articleVO = new ArticleVO();
            BeanUtils.copyProperties(article, articleVO);
            injectTagAndCategory(article, articleVO);
            articleVOList.add(articleVO);
        }
        response.setData(articleVOList);
        return response;
    }

    public BaseResponse<ArticleVO> getArticle(Integer id) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andIdEqualTo(id);
        Article article = getByExample(articleExample);
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        injectTagAndCategory(article, articleVO);
        BaseResponse<ArticleVO> response = new BaseResponse<>();
        return response.setData(articleVO);
    }

    /**
     * 注入tag和category
     * @param article
     * @param articleVO
     */
    public void injectTagAndCategory(Article article, ArticleVO articleVO){
        ArticleTagExample articleTagExample = new ArticleTagExample();
        articleTagExample.createCriteria().andArticleIdEqualTo(article.getId());
        List<ArticleTag> articleTagList = articleTagService.mapper().selectByExample(articleTagExample);
        List<Integer> tagIds = articleTagList.stream().map(articleTag -> articleTag.getId()).collect(Collectors.toList());
        List<String> tagList = new ArrayList<>();
        if (tagIds.size() != 0) {
            TagExample tagExample = new TagExample();
            tagExample.createCriteria().andIdIn(tagIds);
            tagList = tagService.mapper().selectByExample(tagExample)
                    .stream()
                    .map(tag -> tag.getName())
                    .collect(Collectors.toList());
        }

        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andArticleIdEqualTo(article.getId());
        List<ArticleCategory> articleCategoryList = articleCategoryService.mapper().selectByExample(articleCategoryExample);
        List<Integer> categoryIds = articleCategoryList.stream().map(articleCategory -> articleCategory.getId()).collect(Collectors.toList());
        List<String> categoryList = new ArrayList<>();
        if (categoryIds.size() != 0) {
            CategoryExample categoryExample = new CategoryExample();
            categoryExample.createCriteria().andIdIn(categoryIds);
            categoryList = categoryService.mapper().selectByExample(categoryExample)
                    .stream()
                    .map(tag -> tag.getName())
                    .collect(Collectors.toList());
        }
        articleVO.setTagList(tagList);
        articleVO.setCategoryList(categoryList);
    }
    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception {
        return null;
    }


    public Article add(Article article) {
        Article result = null;
//        try {
//            List<ArticleTag> tagList = tagMapper.getList();
//            List<ArticleClass> classList = classMapper.getList();
//            ArticleTag articleTag = new ArticleTag();
//            ArticleClass articleClass = new ArticleClass();
//            TRArticleTag t = new TRArticleTag();
//            TRArticleClass c = new TRArticleClass();
//            articleMapper.insert(article);
//            searchService.indexPro(article.getId());
//            result = articleMapper.getById(article.getId());
//
//            //向数据库插入文章标签关系
//            for(ArticleTag aTag: article.getTagList()){
//                boolean hasTag = false;
//                for(ArticleTag tag: tagList){
//                    if(tag.getTagName().equals(aTag.getTagName())){
//                        t.setArticleId(result.getId());
//                        t.setTagId(tag.getId());
//                        trArticleTagMapper.insert(t);
//                        hasTag = true;
//                        break;
//                    }
//                }
//                //如果数据库中没有这个标签
//                if(!hasTag){
//                    articleTag.setTagName(aTag.getTagName());
//                    tagMapper.insert(articleTag);
//                    ArticleTag resultTag = tagMapper.getById(articleTag.getId());
//                    t.setArticleId(result.getId());
//                    t.setTagId(resultTag.getId());
//                    trArticleTagMapper.insert(t);
//                }
//            }
//
//            //向数据库插入文章类别关系
//            for(ArticleClass aClass: article.getClassList()){
//                boolean hasClass = false;
//
//                for(ArticleClass clazz: classList){
//
//                    if(clazz.getClassName().equals(aClass.getClassName())){
//                        c.setArticleId(result.getId());
//                        c.setClassId(clazz.getId());
//                        trArticleClassMapper.insert(c);
//                        hasClass = true;
//                        break;
//                    }
//                    //如果数据库中没有这个类别
//                    if(!hasClass){
//                        articleClass.setClassName(aClass.getClassName());
//                        classMapper.insert(articleClass);
//                        ArticleClass resultClass = classMapper.getById(articleClass.getId());
//                        c.setArticleId(result.getId());
//                        c.setClassId(resultClass.getId());
//                        trArticleClassMapper.insert(c);
//                    }
//                }
//
//            }
//            result = articleMapper.getById(article.getId());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return result;
    }

    public Article update(Article article) {
        Article result = null;
//        try {
//            int row = articleMapper.update(article);
//            if(row >= 1){
//                result = articleMapper.getById(article.getId());
//            }else{
//                return null;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return result;
    }

    public BaseResponse deleteArticle(Integer id) {
        mapper().deleteByPrimaryKey(id);
        return new BaseResponse();
    }

    @Override
    BaseMapper<Article, ArticleExample> mapper() {
        return articleMapper;
    }
}
