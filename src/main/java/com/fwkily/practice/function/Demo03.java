package com.fwkily.practice.function;

import java.util.function.Consumer;

/**
 * @Author: fuwk
 * @Description:
 * 消费型接口，只有输入，没有返回值
 * @Date: 13:59 2021/8/24
 */
public class Demo03 {

    public static void main(String[] args) {

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        Consumer<String> consumer = System.out::println;

        consumer.accept("jshx");

    }



}
