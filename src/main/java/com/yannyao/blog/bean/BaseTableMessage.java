package com.yannyao.blog.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YannYao
 * @Description:分页对象
 * @Date Created in 13:34 2017/12/11
 */
@Data
public class BaseTableMessage {
    private String sort;    //前端table表sortName属性定义的分类Id
    private String order;   //升序或倒序
    private int offset;     //分页偏移数（下一页就是查往后偏移offset个后，拿limit个）(就是从第几个开始拿)
    private int limit;      //前端需要的数据数
    private int page;
    private int total;      //table需要后台返回两个值，total表示总数
    private Object rows;    //rows放返回数据
    private int status;
    private int tags;


    public Map result(){
        Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
//        map.put("status",status);
        return map;
    }

}
