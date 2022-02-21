package com.fwkily.practice.function;

import java.util.function.Predicate;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 14:59 2021/11/15
 */
public class Demo06 {

    public static void main(String[] args) {

        Predicate<Integer> predicate = a1 -> a1 > 10;
        Predicate<Integer> predicate2 = a1 -> a1 < 20;



        System.out.println(predicate.test(2));

        System.out.println(predicate.and(predicate2).test(60));

        System.out.println(predicate.or(predicate2).test(60));

        System.out.println(Predicate.isEqual(40).test(40));


    }

}
