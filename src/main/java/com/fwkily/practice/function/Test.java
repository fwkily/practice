package com.fwkily.practice.function;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author: fuwk
 * @Description:  ForkJoin测试
 * @Date: 15:06 2021/8/24
 */
public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        Long sum = test1();   //sum: 500000000500000000 时间：3120
//        Long sum = test2();    //sum: 500000000500000000 时间：7750
        Long sum = test3();     //sum: 500000000500000000 时间：115
        long endTime = System.currentTimeMillis();
        System.out.println("sum: " + sum + " 时间：" + (endTime - startTime));
    }


    public static Long test1() {
        long sum = 0L;
        for (Long i = 0L; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        return sum;
    }


    public static Long test2() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinDemo = new ForkJoinDemo(1L, 10_0000_0000L);
        forkJoinPool.execute(forkJoinDemo);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);//提交任务
        return submit.get();
    }


    public static Long test3() {
        //并行流计算  rangeClosed包括起止数
        return LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0L, Long::sum);

    }


}
