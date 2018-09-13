package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.*;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class CategoryService extends BaseService<Category, CategoryExample>{
    @Override
    BaseMapper<Category, CategoryExample> mapper() {
        return null;
    }
}
