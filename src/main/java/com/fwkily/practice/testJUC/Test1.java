package com.fwkily.practice.testJUC;

import java.util.concurrent.TimeUnit;

/**
 * 并发编程的本质：充分利用CPU资源
 */

public class Test1 {


    public static void main(String[] args) {

        System.out.println(args);
        //获取cpu核数
        //CPU密集型   IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
