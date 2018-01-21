package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.Message;
import com.yannyao.blog.bean.Article;
import com.yannyao.blog.service.ArticleService;
import io.swagger.models.auth.In;
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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Message getAll(){

        List<Article> articleList = new ArrayList<>();

        try {
            articleList = articleService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取文章列表失败！",null);
        }
        return new Message(Message.SUCCESS,"获取文章列表成功！",articleList);
    }
    /**
     * 获取文章列表(有分页)
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Message getList(@RequestParam int limit,
                           @RequestParam int page){

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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Message getById(@PathVariable("id") Integer id){
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
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Message add(@RequestBody Article article){
        try {
            Article result = articleService.add(article);
            if(result.getId() > 0){
                return new Message(Message.SUCCESS,"新增文章成功！",result);
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
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Message update(@PathVariable("id") Integer id, @RequestBody Article article){
        try {
            article.setId(id);
            Article result = articleService.update(article);
            if(result != null){
                return new Message(Message.SUCCESS,"修改文章成功！",result);
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
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message delete(@PathVariable(value = "id") Integer id){
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
