package com.yannyao.blog.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = 0,b = 0,c = 0,d = 0;
        String str= null;
        String[] arr = {"Alan","Mike","Tom"};//候选人列表
        String[] list = new String[n];

        for (int i = 0 ; i < list.length ; i ++){
            str = input.next();
            if (str.equals(arr[0])){
                a = a + 1;
            }else if (str.equals(arr[1])){
                b = b + 1;
            }else if (str.equals(arr[2])){
                c = c + 1;
            }else{
                d = d + 1;
            }
            System.out.println("Alan" + a);
            System.out.println("Mike" +b);
            System.out.println("Tom" +c);
            System.out.println("invalid" +d);
        }

    }

}