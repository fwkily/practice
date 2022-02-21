package com.fwkily.practice.function;

import java.util.function.Predicate;

/**
 * @Author: fuwk
 * @Description:
 * 断定性接口：有一个输入参数，返回值只能是布尔值！
 * @Date: 13:46 2021/8/24
 */
public class Demo02 {


    public static void main(String[] args) {

//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test(""));

    }

}
