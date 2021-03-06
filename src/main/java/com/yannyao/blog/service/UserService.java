//package com.yannyao.blog.service;
//
//import com.yannyao.blog.bean.BaseTableMessage;
//import com.yannyao.blog.bean.User;
//
//import java.util.List;
//
///**
// * @Author: YannYao
// * @Description:
// * @Date Created in 13:44 2017/12/11
// */
//public interface UserService {
//    /**
//     * 获取用户列表
//     * @return
//     * @throws Exception
//     */
//    public List<User> getList() throws Exception;
//    /**
//     * 获取用户列表(分页)
//     * @return
//     * @throws Exception
//     */
//    public BaseTableMessage getList(int page, int limit) throws Exception;
//
//    /**
//     * 根据id获取用户
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    public User getById(Integer id) throws Exception;
//    /**
//     * 根据用户名获取用户
//     * @param username
//     * @return
//     * @throws Exception
//     */
//    public User getByUsername(String username) throws Exception;
//
//    /**
//     * 根据TableMessage获取查询到的用户
//     * @param tableMessage
//     * @return
//     * @throws Exception
//     */
//    public BaseTableMessage getSearchList(BaseTableMessage tableMessage) throws Exception;
//    /**
//     * 新增一个用户
//     * @param admin
//     * @return
//     * @throws Exception
//     */
//    public boolean add(User admin) throws Exception;
//    /**
//     * 修改一个用户
//     * @param admin
//     * @return
//     * @throws Exception
//     */
//    public boolean update(User admin) throws Exception;
//
//    /**
//     * 删除一个用户
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    public boolean delete(Integer id) throws Exception;
//    /**
//     * 用户登录验证
//     */
//    public boolean validate(User admin) throws Exception;
//}
