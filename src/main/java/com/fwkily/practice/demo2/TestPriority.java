package com.fwkily.practice.demo2;

/**
 * 测试线程优先级，优先级高的不一定比优先级低的先执行，优先级高的只是先执行的概率高一点，都看cpu心情
 */
public class TestPriority {

    public static void main(String[] args) {

        //主线程设置默认优先级
        System.out.println("main-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority,"线程1");
        Thread thread2 = new Thread(myPriority,"线程2");
        Thread thread3 = new Thread(myPriority,"线程3");
        Thread thread4 = new Thread(myPriority,"线程4");
        Thread thread5 = new Thread(myPriority,"线程5");
        Thread thread6 = new Thread(myPriority,"线程6");

        thread1.start();

        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();

        thread3.setPriority(Thread.NORM_PRIORITY);
        thread3.start();

        thread4.setPriority(Thread.MAX_PRIORITY);
        thread4.start();

        thread5.setPriority(8);
        thread5.start();

        thread6.setPriority(6);
        thread6.start();


    }


}


class MyPriority implements Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

    }
}
