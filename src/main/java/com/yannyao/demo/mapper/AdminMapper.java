package com.yannyao.demo.mapper;

import com.yannyao.demo.bean.Admin;
import com.yannyao.demo.bean.AdminTableMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     * 查询所有管理员列表
     * @return管理员列表
     * @throws Exception
     */
    public List<Admin> getList() throws Exception;

    /**
     * 根据主键获取管理员
     * @param id
     * @return
     * @throws Exception
     */
    public Admin getById(Integer id) throws Exception;

    /**
     * 根据TableMessage和管理员组别查询管理员
     * @param tableMessage
     * @return
     */
    public List<Admin> getSearchList(AdminTableMessage tableMessage) throws Exception;

    /**
     * 根据TableMessage获取查询到的管理员数量
     * @param tableMessage
     * @return
     * @throws Exception
     */
    public Integer getSearchListAmount(AdminTableMessage tableMessage) throws Exception;

    /**
     * 新增一个管理员
     * @param admin
     * @return
     */
    public int insert(Admin admin) throws Exception;

    /**
     * 修改一个管理员
     */
    public int update(Admin admin) throws Exception;

    /**
     * 修改一个管理员
     */
    public int delete(Integer id) throws Exception;
    /**
     * 通过邮箱和密码获得管理员
     */
    public Admin getByEmailAndPwd(Admin admin) throws Exception;

}
