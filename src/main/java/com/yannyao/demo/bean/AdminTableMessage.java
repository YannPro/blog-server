package com.yannyao.demo.bean;

import lombok.Data;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 16:57 2017/12/11
 */
@Data
public class AdminTableMessage extends BaseTableMessage{
    private final static String NICKNAME = "nickname";
    private String nicknameValue;
}
