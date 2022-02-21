package com.fwkily.practice.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁问题，就是关于8个锁的问题
 * 3.增加了一个普通方法，发短信还是hello？  普通方法
 * 4.两个对象， 两个同步方法，发短信还是打电话？   打电话
 */
public class Test2 {


    public static void main(String[] args) {
        //两个对象，两个调用者，两把锁
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        //捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();
        },"B").start();

    }


}

class Phone2{


    //synchronized 锁的对象是方法的调用者
    //两个方法调用的是同一个锁，谁先拿到锁谁执行！
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    //普通方法，没有锁
    public void hello(){
        System.out.println("hello");
    }


}




