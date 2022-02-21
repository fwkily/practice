package com.fwkily.practice.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    public static void test1(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));

        //IllegalStateException: Queue full 抛出异常，队列已满
//        System.out.println(arrayBlockingQueue.add("d"));


        System.out.println(arrayBlockingQueue.element());  //查看队首元素
        System.out.println("=======================");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.element());  //查看队首元素
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());


        //java.util.NoSuchElementException  抛出异常
//        System.out.println(arrayBlockingQueue.remove());

    }

    //有返回值，不抛出异常
    public static void test2(){
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));


        System.out.println(arrayBlockingQueue.offer("d"));//返回false 不抛出异常
        System.out.println(arrayBlockingQueue.peek());  //查看队首元素

        System.out.println("================");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());//返回null  不抛出异常

    }


    //等待 ，阻塞 （一直阻塞）
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
//        arrayBlockingQueue.put("d");   //队列没有位置了，一致阻塞
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());  //没有这个元素


    }

    //等待,阻塞（等待超时）
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");
        arrayBlockingQueue.offer("d",5, TimeUnit.SECONDS); //等待超过2秒就退出


        System.out.println("===============");

        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll();
        arrayBlockingQueue.poll(2,TimeUnit.SECONDS);  //等待超过2秒就退出


    }




}
