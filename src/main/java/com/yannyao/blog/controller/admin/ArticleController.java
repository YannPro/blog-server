package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.bean.Article;
import com.yannyao.blog.service.ArticleService;
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

    /**
     * 获取文章列表
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public Message getList(@RequestParam Integer limit,
                           @RequestParam Integer page){

        List<Article> articleList = new ArrayList<>();

        try {
            articleList = articleService.getList(page, limit);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取文章列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取文章列表成功！",articleList);
    }

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public Message getById(@RequestParam("articleId") Integer id){
        Article article = new Article();
        try {
            article = articleService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取文章失败！", null);
        }
        return new Message(Message.SUCCESS,"获取文章成功！",article);
    }

    /**
     * 根据
     * @param tableMessage
     * @return
     */
    @RequestMapping(value = "/getSearchList", method = RequestMethod.POST)
    @ResponseBody
    public Map getSearchList(@RequestBody BaseTableMessage tableMessage) throws Exception{
        System.out.println(tableMessage);
        return articleService.getSearchList(tableMessage).result();
    }
    /**
     * 新增文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Message add(@RequestBody Article article){
        System.out.println(article.toString());
        try {
            if(articleService.add(article)){
                return new Message(Message.SUCCESS,"新增文章成功！",null);
            }else{
                return new Message(Message.ERROR,"新增文章失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"新增文章失败！",null);
        }
    }

    /**
     * 修改文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Message update(@RequestBody Article article){
        try {
            if(articleService.update(article)){
                return new Message(Message.SUCCESS,"修改文章成功！",null);
            }else{
                return new Message(Message.ERROR,"修改文章失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"修改文章失败！",null);
        }
    }
    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Message delete(@RequestParam(value = "articleId") Integer id){
        try {
            if(articleService.delete(id)){
                return new Message(Message.SUCCESS,"删除文章成功！",null);
            }else{
                return new Message(Message.ERROR,"删除文章失败！",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"删除文章失败！",null);
        }
    }
}
