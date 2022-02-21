package com.fwkily.practice.testThread;

import java.util.Objects;

/**
 * 龟兔赛跑
 */
public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {

        for(int i = 0; i<= 100; i++){

            //模拟兔子睡觉
            if(Objects.equals(Thread.currentThread().getName(), "兔子") && i != 0 && i % 5 == 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameover(i);
            if(flag){
                System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步！");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步！");

        }
    }

    //判断是否完成比赛
    private boolean gameover(int steps){
        if(winner != null){
            System.out.println("比赛结束了");
            return true;
        }
        {
            if(steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner是" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }



}
