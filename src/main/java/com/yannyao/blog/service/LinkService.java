package com.yannyao.blog.service;

import com.yannyao.blog.bean.FriendLink;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2018/1/22
 */
public interface LinkService {
    /**
     * 获取友链列表
     * @return
     * @throws Exception
     */
    public List<FriendLink> getList() throws Exception;
    /**
     * 根据id获取文章
     * @param id
     * @return
     * @throws Exception
     */
    public FriendLink getById(Integer id) throws Exception;

    /**
     * 新增一个友链
     * @param friendLink
     * @return
     * @throws Exception
     */
    public boolean add(FriendLink friendLink) throws Exception;

    /**
     * 删除一个友链
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception;
    /**
     * 修改一个文章
     * @param friendLink
     * @return
     * @throws Exception
     */
    public FriendLink update(FriendLink friendLink) throws Exception;

}
