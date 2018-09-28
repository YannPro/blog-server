package com.yannyao.blog.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yannyao.blog.bean.BaseBean;
import com.yannyao.blog.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

//D:数据库实体类  BaseDomain: 由于id不自增需要自行设置,所以需要继承 DTO：实体类对应的DTO  BaseDTO:带有一个exist字段 用于缓存防击穿  Ex:对应的Example
@Service
public abstract class BaseService<D extends BaseBean, Ex> {

    public D getById(Integer id) {
        try {
//            if (cacheClient() != null) {
//                DTO dto = cacheClient().get(id);
//                if (dto != null) {
//                    if (dto.getExist() != null && dto.getExist().booleanValue() == false) {
//                        return null;
//                    } else {
//                        return dto;
//                    }
//                } else {
//                    return  get(id);
//                }
//            } else {
                return get(id);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("sys error");
        }
    }

    private D get(Integer id) throws IllegalAccessException, InstantiationException {
        D d = mapper().selectByPrimaryKey(id);
        return d;
//        if (d == null && cacheClient() != null) {
//            DTO dto = getDTOClass().newInstance();
//            dto.setExist(false);
//            cacheClient().put(dto);
//            return null;
//        } else {
//            DTO ret = transfer(d);
//            if (cacheClient() != null) {
//                cacheClient().put(ret);
//            }
//            return ret;
//        }
    }

    public int insertSelective(D d) {
        //由于ID不是自增 所有domain都需要继承BaseDomain
//        d.setId(UniqueDBIndexUtil.generate());
        int insert = mapper().insertSelective(d);
//        DTO dto = transfer(d);
//        if (insert > 0 && cacheClient() != null) {
//            cacheClient().put(dto);
//        } else {
//            //TODO:异常待处理
//        }
        return insert;
    }

    public int updateSelective(D d) {
        int update = mapper().updateByPrimaryKeySelective(d);
//        if (update > 0 && cacheClient() != null) {
//            cacheClient().put(transfer(d));
//        } else {
//            //TODO:还没写完
//        }
        return update;
    }

    public List <D> listByExample(Ex example, int page, int pageSize) {
//        List <DTO> ret = new ArrayList <>();
        if (page > 0 && pageSize > 0) {
            PageHelper.startPage(page, pageSize);
        }
        List <D> ds = mapper().selectByExample(example);
        return ds;
//        if (ds != null && ds.size() > 0) {
//            ds.forEach(d -> ret.add(transfer(d)));
//            return ret;
//        } else {
//            return null;
//        }
    }

    public D getByExample(Ex example) {
        PageHelper.startPage(1, 1);
        List <D> ds = mapper().selectByExample(example);
        if (ds != null && ds.size() > 0) {
            return ds.get(0);
        } else {
            return null;
        }
    }

    //所有Mapper都应继承BaseMapper
    abstract BaseMapper<D, Ex> mapper();

//    //获取缓存客户端
//    abstract BaseCacheClient <D> cacheClient();
//
//    //获取DTO类
//    abstract Class <DTO> getDTOClass();
//
//    //D转化成DTO的方法
//    abstract DTO transfer(D d);

    public int delete(Integer id) {
//        if (cacheClient() != null) {
//            cacheClient().remove(id);
//        }
        return mapper().deleteByPrimaryKey(id);
    }

    public int deleteByExample(Ex ex) {
        return mapper().deleteByExample(ex);
    }

    public int countByExample(Ex ex) {
        return (int) mapper().countByExample(ex);
    }

    public int updateByExample(D d, Ex ex) {
//        if (cacheClient() != null) {
//            List <DTO> dtos = listByExample(ex, 0, 0);
//            if (dtos != null && dtos.size() > 0) {
//                dtos.forEach(dto -> cacheClient().remove(dto));
//            }
//        }
        return mapper().updateByExample(d, ex);
    }
}
