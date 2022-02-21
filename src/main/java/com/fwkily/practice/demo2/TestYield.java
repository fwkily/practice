package com.fwkily.practice.demo2;

/**
 *  测试礼让线程
 *  礼让线程，让当前正在执行的线程暂停，但不阻塞
 *  将线程从运行状态变为就绪状态
 *  礼让不一定成功,还得看cpu心情
 */
public class TestYield {

    public static void main(String[] args) {
        Myclass myclass = new Myclass();
        new Thread(myclass,"a").start();
        new Thread(myclass,"b").start();


    }

}


class Myclass implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "线程开始执行！");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程结束执行！");

    }
}
