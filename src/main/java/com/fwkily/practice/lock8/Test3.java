package com.fwkily.practice.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁问题，就是关于8个锁的问题
 * 5.增加两个静态的同步方法，只有一个对象，先打印发短信还是打电话?   发短信
 * 6.两个对象，增加两个静态的同步方法，先打印发短信还是打电话?   发短信
 */
public class Test3 {


    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        Phone3 phone2 = new Phone3();

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

class Phone3{


    //synchronized 锁的对象是方法的调用者
    //static静态方法
    //类一加载就有了，锁的是class
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }

    //普通方法，没有锁
    public void hello(){
        System.out.println("hello");
    }


}




