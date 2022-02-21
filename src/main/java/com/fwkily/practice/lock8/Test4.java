package com.fwkily.practice.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁问题，就是关于8个锁的问题
 * 1.1个静态的同步方法，1个普通的同步方法，一个对象，先发短信or先打电话？  打电话
 * 2.1个静态的同步方法，1个普通的同步方法，两个，先发短信or先打电话？  打电话
 */
public class Test4 {


    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();

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

class Phone4{


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

    //普通的同步方法，锁的是对象，和上面的不是同一把锁
    public synchronized void call(){
        System.out.println("打电话");
    }

    //普通方法，没有锁
    public void hello(){
        System.out.println("hello");
    }


}




