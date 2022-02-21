package com.fwkily.practice.function;

import java.util.function.Consumer;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 14:59 2021/11/15
 */
public class Demo07 {

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer2 = a -> {Integer i = 1;
            System.out.println(i + "哈哈");};

        consumer.accept("我是你die");

        consumer.andThen(consumer2).accept("黄金山东金佛山");

    }

}
