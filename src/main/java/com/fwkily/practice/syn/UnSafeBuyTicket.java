package com.fwkily.practice.syn;

/**
 * 不安全买票
 * 线程不安全，有负数
 */
public class UnSafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"苦逼的我").start();
        new Thread(buyTicket,"牛逼的你们").start();
        new Thread(buyTicket,"可恶的黄牛党").start();

    }

}


class BuyTicket implements Runnable{


    //票
    private int ticketNum = 10;

    boolean flag = true;

    @Override
    public void run() {

        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private synchronized void buy() throws InterruptedException {
        if(ticketNum <= 0){
            flag = false;
            return;
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNum-- + "张票！");

    }
}
