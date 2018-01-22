package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.ArticleTag;
import com.yannyao.blog.bean.FriendLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {

    /**
     * 查询所有友链列表
     * @return友链列表
     * @throws Exception
     */
    public List<FriendLink> getList() throws Exception;
    /**
     * 根据主键获取友链
     * @param id
     * @return
     * @throws Exception
     */
    public FriendLink getById(Integer id) throws Exception;

    /**
     * 新增一个友链
     * @param friendLink
     * @return
     */

    public int insert(FriendLink friendLink) throws Exception;

    /**
     * 修改一个友链
     */
    public int update(FriendLink friendLink) throws Exception;

    /**
     * 删除一个友链
     * @param id
     * @return
     * @throws Exception
     */
    public int delete(Integer id) throws Exception;

}
