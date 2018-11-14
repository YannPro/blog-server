package com.yannyao.blog.service.Impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yannyao.blog.bean.*;
import com.yannyao.blog.common.exception.BaseErrors;
import com.yannyao.blog.common.exception.BusinessException;
import com.yannyao.blog.common.module.vo.ArticleVO;
import com.yannyao.blog.common.request.AddCategoryRequest;
import com.yannyao.blog.common.request.SetArticleRequest;
import com.yannyao.blog.common.request.ListArticleRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.common.response.PageResponse;
import com.yannyao.blog.common.util.ObjectUtil;
import com.yannyao.blog.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        List<Tag> tagList = new ArrayList<>();
        articleTagList.stream().forEach(articleTag -> {
            Tag tag = tagService.mapper().selectByPrimaryKey(articleTag.getTagId());
            if (tag != null) {
                tagList.add(tag);
            }
        });
        articleVO.setTagList(tagList);

        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andArticleIdEqualTo(article.getId());
        List<ArticleCategory> articleCategoryList = articleCategoryService.mapper().selectByExample(articleCategoryExample);
        List<Category> categoryList = new ArrayList<>();
        articleCategoryList.stream().forEach(articleCategory -> {
            Category category = categoryService.mapper().selectByPrimaryKey(articleCategory.getCategoryId());
            if (category != null) {
                categoryList.add(category);
            }
        });
        articleVO.setCategoryList(categoryList);

//        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
//        articleCategoryExample.createCriteria().andArticleIdEqualTo(article.getId());
//        List<ArticleCategory> articleCategoryList = articleCategoryService.mapper().selectByExample(articleCategoryExample);
//        List<Integer> categoryIds = articleCategoryList.stream().map(articleCategory -> articleCategory.getCategoryId()).collect(Collectors.toList());
//        List<String> categoryList = new ArrayList<>();
//        if (categoryIds.size() != 0) {
//            CategoryExample categoryExample = new CategoryExample();
//            categoryExample.createCriteria().andIdIn(categoryIds);
//            categoryList = categoryService.mapper().selectByExample(categoryExample)
//                    .stream()
//                    .map(tag -> tag.getName())
//                    .collect(Collectors.toList());
//        }
//        articleVO.setTagList(tagList);
//        articleVO.setCategoryList(categoryList);
    }
    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception {
        return null;
    }

    @Transactional
    public BaseResponse addArticle(SetArticleRequest request) {
        Article article = new Article();
        BeanUtils.copyProperties(request, article);
        insertSelective(article);
        if (ObjectUtil.isEmpty(request.getCategoryList()) || ObjectUtil.isEmpty(request.getTagList())) {
            throw new BusinessException("标签/类目不能为空", BaseErrors.REQUEST_PARAM_ERROR);
        }
        request.getCategoryList().forEach(category -> {
            if (category != null) {
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setSeqId(request.getCategoryList().indexOf(category));
                articleCategory.setArticleId(article.getId());
                articleCategory.setCategoryId(category.getId());
                articleCategoryService.insertSelective(articleCategory);
            }
        });
        request.getTagList().forEach(tag -> {
            if (tag != null) {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setSeqId(request.getTagList().indexOf(tag));
                articleTag.setArticleId(article.getId());
                articleTag.setTagId(tag.getId());
                articleTagService.insertSelective(articleTag);
            }
        });
        return new BaseResponse();
    }

    @Transactional
    public BaseResponse updateArticle(SetArticleRequest request) {
        if (ObjectUtil.isEmpty(request.getId())) {
            return new BaseResponse();
        }
        Article article = new Article();
        BeanUtils.copyProperties(request, article);
        updateSelective(article);
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andArticleIdEqualTo(request.getId());
        articleCategoryService.deleteByExample(articleCategoryExample);

        ArticleTagExample articleTagExample = new ArticleTagExample();
        articleTagExample.createCriteria().andArticleIdEqualTo(request.getId());
        articleTagService.deleteByExample(articleTagExample);

        request.getCategoryList().forEach(category -> {
            if (category != null) {
                if (category.getId() == null) {
                    categoryService.mapper().insertSelective(category);
                }
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setSeqId(request.getCategoryList().indexOf(category));
                articleCategory.setArticleId(article.getId());
                articleCategory.setCategoryId(category.getId());
                articleCategoryService.insertSelective(articleCategory);
            }
        });
        request.getTagList().forEach(tag -> {
            if (tag.getId() == null) {
                tagService.mapper().insertSelective(tag);
            }
            if (tag != null) {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setSeqId(request.getTagList().indexOf(tag));
                articleTag.setArticleId(article.getId());
                articleTag.setTagId(tag.getId());
                articleTagService.insertSelective(articleTag);
            }
        });
        return new BaseResponse();
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
