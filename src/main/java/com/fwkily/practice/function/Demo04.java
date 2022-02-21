package com.fwkily.practice.function;

import java.util.function.Supplier;

/**
 * @Author: fuwk
 * @Description:
 * 供给型接口，无参数，有返回值
 * @Date: 13:59 2021/8/24
 */
public class Demo04 {

    public static void main(String[] args) {

//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "fwk nb!";
//            }
//        };

        Supplier<String> supplier = () -> "fwk nb!";


        System.out.println(supplier.get());

    }



}
