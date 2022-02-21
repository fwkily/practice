package com.fwkily.practice.unsafe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread myThread = new MyThread();
        //FutureTask 适配类
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start(); //结果会被缓存，效率高
        Integer integer = futureTask.get();//这个get方法可能会产生阻塞，！把他放到最后或者用异步通信来处理！
        System.out.println(integer);


    }

}


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }

}
