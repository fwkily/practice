package com.fwkily.practice.testJUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基本的卖票例子
 */
public class SaleTicketDemo02 {

    public static void main(String[] args) {

        System.out.println("开始时间：" + System.currentTimeMillis());
        Ticket02 ticket = new Ticket02();
        new Thread(() ->{

            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(() ->{
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(() ->{
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();

        System.out.println("结束时间：" + System.currentTimeMillis());


    }

}

//lock 三部曲
//1      Lock lock = new ReentrantLock();
//2 加锁  lock.lock();
//3 解锁  lock.unlock();
class Ticket02 {

    private int num = 50;

    Lock lock = new ReentrantLock();

    //synchronized  本质  队列  锁
    public synchronized void sale(){
        //加锁
        lock.lock();
        try {
            if(num > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了第" + num-- + "张票，剩余：" + num + "张票！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //解锁
            lock.unlock();
        }

    }

}

