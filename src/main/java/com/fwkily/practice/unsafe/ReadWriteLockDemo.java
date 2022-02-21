package com.fwkily.practice.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 独占锁（一次只能被一个线程占有）
 * 共享锁（多个线程可以同时占有）
 * readWriteLock
 * 读-读 key共存
 * 读-写 不能共存
 * 写-写 不能共存
 *
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        for (int i = 1; i <= 5 ; i++) {
            final int temp = i;
            new Thread(()->{
                myLock.put(temp + "", temp + "");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5 ; i++) {
            final int temp = i;
            new Thread(()->{
                myLock.get(temp + "");
            },String.valueOf(i)).start();
        }
    }
}

//自定义缓存
class MyLock{

    private volatile Map<String,Object> map = new HashMap<>();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        //存，写入，只希望一个线程写入
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入ok" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }


    public void get(String key){
        //读取，key多个线程读
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取ok" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}