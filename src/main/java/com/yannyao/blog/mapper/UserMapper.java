package com.yannyao.blog.mapper;

import com.yannyao.blog.bean.BaseTableMessage;
import com.yannyao.blog.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户列表
     * @return用户列表
     * @throws Exception
     */
    public List<User> getList() throws Exception;

    /**
     * 根据主键获取用户
     * @param id
     * @return
     * @throws Exception
     */
    public User getById(Integer id) throws Exception;

    /**
     * 根据用户名获取用户
     * @param id
     * @return
     * @throws Exception
     */
    public User getByUserName(String username) throws Exception;

    /**
     * 根据TableMessage和用户组别查询用户
     * @param tableMessage
     * @return
     */
    public List<User> getSearchList(BaseTableMessage tableMessage) throws Exception;

    /**
     * 根据TableMessage获取查询到的用户数量
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public Integer getSearchListAmount(BaseTableMessage tableMessage) throws Exception;

    /**
     * 新增一个用户
     * @param user
     * @return
     */
    public int insert(User user) throws Exception;

    /**
     * 修改一个用户
     */
    public int update(User user) throws Exception;

    /**
     * 修改一个用户
     */
    public int delete(Integer id) throws Exception;
    /**
     * 通过邮箱和密码获得用户
     */
    public User getByEmailAndPwd(User user) throws Exception;

}
