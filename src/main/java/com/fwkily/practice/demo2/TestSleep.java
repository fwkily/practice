package com.fwkily.practice.demo2;


//模拟延时  放大问题的发生性
public class TestSleep implements Runnable {



    private int ticketNum = 10;

    @Override
    public void run() {


        while (true){
            if(ticketNum <= 0){
                break;
            }

            //模拟延时
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "张票！");
        }

    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小红").start();
        new Thread(ticket,"黄牛").start();
    }
}
