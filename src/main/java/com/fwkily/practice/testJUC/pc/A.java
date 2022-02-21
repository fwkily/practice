package com.fwkily.practice.testJUC.pc;

public class A {

    public static void main(String[] args) {


        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"D").start();

    }

}


class Data{


    private int num = 0;

    public synchronized void increment() throws InterruptedException {
//        if(num != 0){
//            this.wait();
//        }
        //注意：使用if可能会造成虚假唤醒问题 ，使用while替代if解决
        while (num != 0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        this.notifyAll();

    }

    public synchronized void decrement() throws InterruptedException {
//        if(num == 0){
//            this.wait();
//        }
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        this.notifyAll();

    }


}
