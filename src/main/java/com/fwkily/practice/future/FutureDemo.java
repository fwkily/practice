package com.fwkily.practice.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:59 2021/8/24
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //没有返回值的runAsync 异步回调
//        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(Thread.currentThread().getName() + "Void!");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println("11111");
//        future.get();      //获取阻塞执行结果

        //有返回值的runAsync 异步回调
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync");
            int a = 10/0;
            return 1024;
        }).whenComplete((t,u)->{
            System.out.println("t =>" + t);  //正常的返回结果
            System.out.println("u =>" + u);  //java.lang.ArithmeticException: / by zero  异常值
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return 2333;
        });

    }


}
