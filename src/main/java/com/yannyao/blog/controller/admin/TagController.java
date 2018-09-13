//package com.yannyao.blog.controller.admin;
//
//import com.yannyao.blog.bean.ArticleTag;
//import com.yannyao.blog.bean.Message;
//import com.yannyao.blog.service.TagService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin/tag")
//public class TagController {
//
//    @Autowired
//    private TagService tagService;
//
//    /**
//     * 获取标签列表
//     * @return
//     */
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    @ResponseBody
//    public Message getList(){
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
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    @ResponseBody
//    public Message add(@RequestBody ArticleTag tag){
//        System.out.println(tag.toString());
//        try {
//            if(tagService.add(tag)){
//                return new Message(Message.SUCCESS,"新增标签成功！",null);
//            }else{
//                return new Message(Message.ERROR,"新增标签失败！",null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"新增标签失败！",null);
//        }
//    }
//
//    /**
//     * 删除标签
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Message delete(@PathVariable(value = "id") Integer id){
//        try {
//            if(tagService.delete(id)){
//                return new Message(Message.SUCCESS,"删除标签成功！",null);
//            }else{
//                return new Message(Message.ERROR,"删除标签失败！",null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Message(Message.ERROR,"删除标签失败！",null);
//        }
//    }
//}
