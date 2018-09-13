package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.FriendLink;
import com.yannyao.blog.mapper.LinkMapper;
import com.yannyao.blog.service.LinkService;
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
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public List<FriendLink> getList() {
        List<FriendLink> linkList = new ArrayList<>();
        try {
            linkList = linkMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return linkList;
    }

    @Override
    public FriendLink getById(Integer id) {
        FriendLink friendLink = new FriendLink();
        try {
            friendLink = linkMapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return friendLink;
    }

    @Override
    public boolean add(FriendLink friendLink) {

        boolean state = false;
        try {
            state = linkMapper.insert(friendLink) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }
    @Override
    public FriendLink update(FriendLink friendLink) {
        FriendLink result = null;
        try {
            int row = linkMapper.update(friendLink);
            if(row >= 1){
                result = linkMapper.getById(friendLink.getId());
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean state = false;
        try {
            state = linkMapper.delete(id) == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

}
