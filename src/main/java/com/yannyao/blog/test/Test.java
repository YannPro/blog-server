package com.yannyao.blog.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Test {
    public List<String> list;
    public static void main(String[] args) {
        Test test = new Test();
        test.setList(new ArrayList<>());

    }

}