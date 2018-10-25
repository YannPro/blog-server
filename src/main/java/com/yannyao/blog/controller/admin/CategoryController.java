package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.Category;
import com.yannyao.blog.common.request.AddCategoryRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    @ResponseBody
    public BaseResponse<List<Category>> getList(){
        return categoryService.listCategory();
    }

    @PostMapping("/addCategory")
    @ResponseBody
    public BaseResponse addCategory(@Valid AddCategoryRequest request){
        return categoryService.addCategory(request);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse delete(@PathVariable(value = "id") Integer id){
        return categoryService.deleteCategory(id);
    }
}
