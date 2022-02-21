package com.fwkily.practice.pool;

import java.util.concurrent.*;

/**
 * @Author: fuwk
 * @Description:
 *
 * 四种拒绝策略
 * new ThreadPoolExecutor.AbortPolicy()  //银行满了，还有人进来，不处理这个人的，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()  //哪来的回哪里
 * new ThreadPoolExecutor.DiscardPolicy()     //队列满了，丢掉任务，不会抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy()  //队列满了，尝试去和最早的竞争，也不会抛出异常
 *
 *
 * @Date: 9:52 2021/8/24
 */
public class Demo02 {


    public static void main(String[] args) {

        //获取cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //自定义线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                //最大线程数到底该如何定义？
                //1.cpu密集型  几核，就是几，可以保持cpu的效率最高
                //2.IO密集型   >  判断你程序中十分耗io的线程
                //程序  15个大型任务，io十分占资源！
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()

        );


        try {
            //最大承载   Deque + max
            for (int i = 1; i <= 9; i++) {
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
