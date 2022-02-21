package com.fwkily.practice.function;

import java.util.function.Supplier;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 14:59 2021/11/15
 */
public class Demo08 {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "2134";

        System.out.println(supplier.get());

    }

}
