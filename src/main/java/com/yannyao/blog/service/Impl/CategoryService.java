package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.*;
import com.yannyao.blog.common.module.dto.CategoryDTO;
import com.yannyao.blog.common.module.dto.TagDTO;
import com.yannyao.blog.common.request.AddCategoryRequest;
import com.yannyao.blog.common.request.AddTagRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.CategoryMapper;
import com.yannyao.blog.mapper.TagMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class CategoryService extends BaseService<Category, CategoryExample>{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    BaseMapper<Category, CategoryExample> mapper() {
        return categoryMapper;
    }

    public BaseResponse<List<Category>> listCategory () {
        BaseResponse<List<Category>> response = new BaseResponse<>();
        List<Category> categoryList = listByExample(new CategoryExample(), 1, 1000);
        return response.setData(categoryList);
    }

    @Transactional
    public BaseResponse addCategory (AddCategoryRequest request) {
        List<CategoryDTO> categoryDTOList = request.getCategoryList();
        categoryDTOList.forEach(categoryDTO -> {
            Category category = new Category();
            BeanUtils.copyProperties(categoryDTO, category);
            mapper().insertSelective(category);
        });
        return new BaseResponse();
    }

    @Transactional
    public BaseResponse deleteCategory (Integer id) {
        mapper().deleteByPrimaryKey(id);
        return new BaseResponse();
    }
}
