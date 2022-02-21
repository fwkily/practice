package com.fwkily.practice.unsafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 *抢车位问题
 */
public class SemaphoreDemo {


    public static void main(String[] args) {

        //线程数量：停车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {

            new Thread(()->{
                try {
                    //acquire()得到
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    //睡眠两秒
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();


        }



    }


}
