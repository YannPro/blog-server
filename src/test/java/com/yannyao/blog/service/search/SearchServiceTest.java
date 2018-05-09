package com.yannyao.blog.service.search;

import com.yannyao.blog.DemoApplicationTests;
import com.yannyao.blog.bean.Article;
import com.yannyao.blog.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class SearchServiceTest extends DemoApplicationTests{

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SearchService searchService;

    @Test
    public void indexPro() {
        System.out.printf("dasd");
        try {
            List<Article> articleList = articleService.getAll();

            for (Article article: articleList) {
                Integer id = article.getId();
                searchService.indexPro(id);
//                Assert.assertTrue(isSuccess);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}