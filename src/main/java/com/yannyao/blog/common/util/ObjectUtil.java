package com.yannyao.blog.common.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Auther: YJY
 * @Date: 2018/9/28 11:04
 * @Description:
 */
public class ObjectUtil {

    /**
     * 对象非空
     */
    public static boolean isEmpty(Object obj){
        if (obj == null) {
            return true;
        } else if (obj instanceof CharSequence) {
            return ((CharSequence)obj).length() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Collection) {
            return ((Collection)obj).isEmpty();
        } else {
            return obj instanceof Map ? ((Map)obj).isEmpty() : false;
        }
    }

    /**
     * 对象空
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(isEmpty(list));
    }
}