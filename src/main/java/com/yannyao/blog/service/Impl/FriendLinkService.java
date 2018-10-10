package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.FriendLink;
import com.yannyao.blog.bean.FriendLinkExample;
import com.yannyao.blog.common.request.AddFriendLinkRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.FriendLinkMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class FriendLinkService extends BaseService<FriendLink, FriendLinkExample>{

    @Autowired
    private FriendLinkMapper friendLinkMapper;

    @Override
    BaseMapper<FriendLink, FriendLinkExample> mapper() {
        return friendLinkMapper;
    }

    public BaseResponse<List<FriendLink>> listFriendLink () {
        BaseResponse<List<FriendLink>> response = new BaseResponse<>();
        FriendLinkExample friendLinkExample = new FriendLinkExample();
        friendLinkExample.setOrderByClause("seqId asc");
        List<FriendLink> friendLinkList = listByExample(friendLinkExample, 0, 0);
        return response.setData(friendLinkList);
    }

    @Transactional
    public BaseResponse<FriendLink> addFriendLink (AddFriendLinkRequest request) {
        FriendLink friendLink = new FriendLink();
        BeanUtils.copyProperties(request, friendLink);
        insertSelective(friendLink);
        return new BaseResponse().setData(friendLink);
    }

    @Transactional
    public BaseResponse deleteFriendLink (Integer id) {
        mapper().deleteByPrimaryKey(id);
        return new BaseResponse();
    }
}
