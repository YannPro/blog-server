package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.Tag;
import com.yannyao.blog.common.request.AddTagRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.service.Impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/all")
    @ResponseBody
    public BaseResponse<List<Tag>> getList(){
        return tagService.listTag();
    }

    @PostMapping
    @ResponseBody
    public BaseResponse addTag(@Valid AddTagRequest request){
        return tagService.addTag(request);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse delete(@PathVariable(value = "id") Integer id){
        return tagService.deleteTag(id);
    }
}
