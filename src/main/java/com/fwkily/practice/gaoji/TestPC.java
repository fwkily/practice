package com.fwkily.practice.gaoji;

/**
 * 测试：生产者消费者模型   --》利用缓冲区解决  管程法
 * 生产者   消费者    产品   缓冲区
 */
public class TestPC {


    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Producer(synContainer).start();
        new Customer(synContainer).start();
    }

}


//生产者
class Producer extends Thread{

    private SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            synContainer.push(new Chicken(i));
        }
    }
}

//消费者
class Customer extends Thread{
    private SynContainer synContainer;

    public Customer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + synContainer.pop().id + "只鸡！");
        }
    }
}

//产品
class Chicken{

    public int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器大小
    Chicken[] chickens = new Chicken[10];

    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要等待消费者消费
        if(count == chickens.length){
            //通知消费者消费 ，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就需要丢入产品
//        if(count > -1 && count < 10) {
            chickens[count] = chicken;
//        }
        count++;

        //可以通知消费者消费了
        this.notifyAll();

    }

    //消费者消费产品
    public synchronized Chicken pop(){
        if(count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
//        Chicken chicken = new Chicken(0);
//        if(count > -1 && count < 10){
            Chicken chicken = chickens[count];
//        }
        //吃完了，通知生产者生产
        this.notifyAll();
        return chicken;




    }





}



