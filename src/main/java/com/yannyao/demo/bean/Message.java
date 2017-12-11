package com.yannyao.demo.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:12 2017/12/11
 */

@Data
@AllArgsConstructor
public class Message {
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;
    private int status;
    private String message;
    private Object result;

    public String toJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result =  objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
