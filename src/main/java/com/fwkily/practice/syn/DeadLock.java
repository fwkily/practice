package com.fwkily.practice.syn;


/**
 * 模拟死锁
 */
public class DeadLock {

    public static void main(String[] args) {
        Makeup m1 = new Makeup(0, "灰姑凉");

        Makeup m2 = new Makeup(1, "白雪公主");

        m1.start();
        m2.start();

    }






}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class Makeup extends Thread {

    //static保证需要的资源只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName; //女孩名


    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(girlName + "获得了口红的锁！");
                //一秒钟后想获得镜子
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(girlName + "获得了镜子的锁!");
                }
            }

        } else {
            synchronized (mirror) {
                System.out.println(girlName + "获得了镜子的锁！");
                Thread.sleep(2000);
                //一秒钟后想获得镜子
                synchronized (lipstick){
                    System.out.println(girlName + "获得了口红的锁!");
                }
            }

        }

    }


}

