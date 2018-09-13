package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.Tag;
import com.yannyao.blog.bean.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TagMapper extends BaseMapper<Tag, TagExample> {
}