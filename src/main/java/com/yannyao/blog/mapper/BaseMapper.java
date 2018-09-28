package com.yannyao.blog.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseMapper<T, Ex> {
    int countByExample(Ex ex);

    int deleteByPrimaryKey(Integer id);

    int deleteByExample(Ex ex);

    int insert(T t);

    int insertSelective(T record);

    List <T> selectByExampleWithRowbounds(Ex ex, RowBounds rowBounds);

    List <T> selectByExample(Ex ex);

    T selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") T t, @Param("example") Ex e);

    int updateByExample(@Param("record") T t, @Param("example") Ex e);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);


}
