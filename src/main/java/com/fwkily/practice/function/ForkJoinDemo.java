package com.fwkily.practice.function;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 14:55 2021/8/24
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private Long temp = 1000L;  //临界值，10000


    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if(end-start < temp){
            long sum = 0L;
            for (Long i = start;i <= end;i++){
                sum += i;
            }
            return sum;
        }else {

            //使用forkjoin
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
