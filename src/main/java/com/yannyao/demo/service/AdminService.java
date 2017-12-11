package com.yannyao.demo.service;

import com.yannyao.demo.bean.Admin;
import com.yannyao.demo.bean.AdminTableMessage;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
public interface AdminService {
    /**
     * 获取管理员列表
     * @return
     * @throws Exception
     */
    public List<Admin> getList() throws Exception;

    /**
     * 根据id获取管理员
     * @param id
     * @return
     * @throws Exception
     */
    public Admin getById(Integer id) throws Exception;

    /**
     * 根据TableMessage获取查询到的管理员
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public AdminTableMessage search(AdminTableMessage tableMessage) throws Exception;
    /**
     * 新增一个管理员
     * @param admin
     * @return
     * @throws Exception
     */
    public boolean add(Admin admin) throws Exception;
    /**
     * 修改一个管理员
     * @param user
     * @return
     * @throws Exception
     */
    public boolean update(Admin user) throws Exception;

    /**
     * 删除一个管理员
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception;
    /**
     * 管理员登录验证
     */
    public boolean validate(Admin user) throws Exception;
}
