package com.fwkily.practice.testThread;


/**
 * 出现问题：多个线程操作同一个对象，会造成数据紊乱
 */
public class Thread3 implements Runnable{


    private int ticketNum = 10;

    @Override
    public void run() {


        while (true){
            if(ticketNum <= 0){
                break;
            }

            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "张票！");
        }

    }

    public static void main(String[] args) {
        Thread3 ticket = new Thread3();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小红").start();
        new Thread(ticket,"黄牛").start();
    }

}
