package com.fwkily.practice.testThread;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("学习多线程ing！" + i);
        }
    }

    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        new Thread(thread2).start();

        for(int i = 0; i < 100; i++){
            System.out.println("敲代码ing！" + i);
        }
    }

}
