package com.fwkily.practice.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: fuwk
 * @Description:
 *
 * Executors  工具类   3大方法
 *
 * @Date: 9:52 2021/8/24
 */
public class Demo01 {


    public static void main(String[] args) {

//        ExecutorService threadPool = Executors.newSingleThreadExecutor();  //创建单个线
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定的线程池的大小
        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的，遇强则强，遇弱则弱

        try {
            for (int i = 1; i < 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok!");

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }

}
