package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.ArticleClass;
import com.yannyao.blog.mapper.ClassMapper;
import com.yannyao.blog.service.ClassService;
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
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassMapper classMapper;
    @Override
    public List<ArticleClass> getList() {
        List<ArticleClass> classList = new ArrayList<>();
        try {
            classList = classMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return classList;
    }

    @Override
    public boolean add(ArticleClass clazz) {

        boolean state = false;
        try {
            state = classMapper.insert(clazz) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }


    @Override
    public boolean delete(Integer id) {
        boolean state = false;
        try {
            state = classMapper.delete(id) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

}
