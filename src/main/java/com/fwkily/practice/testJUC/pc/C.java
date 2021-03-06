package com.fwkily.practice.testJUC.pc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition实现精准唤醒
 */
public class C {

    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();

    }
}



class Data3{

    private Lock lock = new ReentrantLock();

    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int num = 1;  //1 A打印   2 B打印  3 C打印

    public void printA(){
        lock.lock();
        try {
            //业务
            if(num != 1){
                //A等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAA");
            //唤醒B
            num = 2;
            //唤醒指定的人
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB(){
        lock.lock();
        try {
            //业务
            if(num != 2){
                //B等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBBB");
            //唤醒C
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public void printC(){
        lock.lock();
        try {
            //业务
            if(num != 3){
                //C等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCCCC");
            //唤醒A
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}
