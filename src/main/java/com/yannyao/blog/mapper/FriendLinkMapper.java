package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.FriendLink;
import com.yannyao.blog.bean.FriendLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FriendLinkMapper extends BaseMapper<FriendLink, FriendLinkExample> {
}