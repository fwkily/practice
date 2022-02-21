package com.fwkily.practice.unsafe;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.util.ConcurrentModificationException  并发修改异常
 */

public class ListTest {


    public static void main(String[] args) {

        //并发下，ArrayList 是不安全的
        /**
         * 解决方案
         *   1.      List<String> list = new Vector<>(); 底层使用synchronized
         *   2.      List<String> list = Collections.synchronizedList(new ArrayList<>());
         *   3.      List<String> list = new CopyOnWriteArrayList<>(); 底层是ReentrantLock，比synchronized效率更高
         *
         *
         */
//        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        //CopyOnWriteArrayList写入时复制， cow 计算机程序设计领域的一种优化策略
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);

            },String.valueOf(i)).start();
        }

    }

}


