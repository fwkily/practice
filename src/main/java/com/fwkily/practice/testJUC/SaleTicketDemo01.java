package com.fwkily.practice.testJUC;

/**
 * 基本的卖票例子
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {

        System.out.println("开始时间：" + System.currentTimeMillis());


        Ticket ticket = new Ticket();
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

class Ticket {

    private int num = 50;

    //synchronized  本质  队列  锁
    public synchronized void sale(){
        if(num > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了第" + num-- + "张票，剩余：" + num + "张票！");

        }
    }

}
