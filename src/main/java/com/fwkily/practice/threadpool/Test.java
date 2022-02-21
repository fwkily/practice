package com.fwkily.practice.threadpool;

import java.util.concurrent.*;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 18:08 2022/1/6
 */
public class Test {

    public static void main(String[] args) {
        final ExecutorService EXECUTOR_BILL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, Integer.MAX_VALUE,
                0, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        CompletionService<Boolean> completionService = new ExecutorCompletionService<>(EXECUTOR_BILL);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            completionService.submit(() -> {
                new Thread(() -> System.out.println("线程" + finalI + "执行任务"),"线程" + finalI).start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
                return true;
            });
        }
        for (int i = 0; i < 10; i++) {
            try {
                Boolean aBoolean = completionService.take().get();
                System.out.println("返回结果" + aBoolean);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("任务都就绪！");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是主线程执行下面的任务！");
        //退出线程池  ---一定要shutdown掉线程池，不然主线程不会结束
//        EXECUTOR_BILL.shutdown();
    }

}
