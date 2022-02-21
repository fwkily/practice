package com.fwkily.practice.gaoji;

import java.util.concurrent.*;

public class TestPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> submit = executorService.submit(new MyThread2());
        Future<String> submit1 = executorService.submit(new MyThread2());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        String s = submit.get();
        String s1 = submit1.get();

        System.out.println(s);
        System.out.println(s1);

        executorService.shutdown();

    }


}


class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread2 implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "你好！";
    }
}
