package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Category;
import com.yannyao.blog.bean.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CategoryMapper extends BaseMapper<Category, CategoryExample> {
}