package com.fwkily.practice.function;

import java.util.function.Function;

/**
 * @Author: fuwk
 * @Description:
 * Function函数型接口，有一个输入参数，有一个输出
 * 只要是函数型接口，就可以用lambda表达式简化
 * @Date: 11:28 2021/8/24
 */
public class Demo01 {

    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        Function fun = s -> {return s;};


        System.out.println(function.apply("你好！"));
        System.out.println(fun.apply("你好a ！"));


    }



}
