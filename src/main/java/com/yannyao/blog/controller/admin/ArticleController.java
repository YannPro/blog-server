package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.Article;
import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.common.module.vo.ArticleVO;
import com.yannyao.blog.common.request.SetArticleRequest;
import com.yannyao.blog.common.request.ListArticleRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.common.response.PageResponse;
import com.yannyao.blog.service.Impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    public static void main(String[] args) {

    }
    /**
     * 获取文章列表
     * @return
     */
////    @RequiresAuthentication
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    @ResponseBody
//    public Message getAll(){
////        boolean isLogined = SecurityUtils.getSubject().isAuthenticated();
////        if(isLogined){
////            System.out.println("hahahaha");
////        }
//        List<Article> articleList = new ArrayList<>();
//
//        try {
//            articleList = articleService.getAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"获取文章列表失败！",null);
//        }
//        return new Message(Message.SUCCESS,"获取文章列表成功！",articleList);
//    }
    /**
     * 获取文章列表(有分页)
     * @return
     */
    @GetMapping("/listArticle")
    @ResponseBody
    public PageResponse<ArticleVO> listArticle(ListArticleRequest request){
        return articleService.listArticle(request);
    }
    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public BaseResponse<ArticleVO> getArticle(@PathVariable("id") Integer id){
        return articleService.getArticle(id);
    }
//
//    /**
//     * 根据
//     * @param tableMessage
//     * @return
//     */
//    @RequestMapping(value = "/getSearchList", method = RequestMethod.POST)
//    @ResponseBody
//    public Map getSearchList(@RequestBody BaseTableMessage tableMessage) throws Exception{
//        System.out.println(tableMessage);
//        return articleService.getSearchList(tableMessage).result();
//    }

    @PostMapping
    @ResponseBody
    public BaseResponse addArticle(@RequestBody SetArticleRequest request){
        return articleService.addArticle(request);
    }

    @PutMapping
    @ResponseBody
    public BaseResponse updateArticle(@RequestBody SetArticleRequest request){
        return articleService.updateArticle(request);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse deleteArticle(@PathVariable(value = "id") Integer id){
        return articleService.deleteArticle(id);
    }
}
