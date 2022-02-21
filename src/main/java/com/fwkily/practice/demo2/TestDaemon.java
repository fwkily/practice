package com.fwkily.practice.demo2;


/**
 * 测试守护线程
 * 上帝守护你
 */
public class TestDaemon {


    public static void main(String[] args) {
        God god = new God();
        Yo you = new Yo();

        Thread t1 = new Thread(god);
        t1.setDaemon(true);
        t1.start(); //上帝守护线程启动！

        new Thread(you).start(); //you 用户线程启动！

    }

}


//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝守护着你！");
        }
    }
}

//你
class Yo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心的活着ing" + i);
        }
        System.out.println("=====goodbye  world!=======");

    }
}
