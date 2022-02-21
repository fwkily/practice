package com.fwkily.practice.demo2;


import java.util.Date;

//模拟倒计时
public class TestSleep2 {

    public static void main(String[] args) {
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Date startTime = new Date(System.currentTimeMillis());
        System.out.println("当前时间为：" + startTime);
        while (true){
            try {
                Thread.sleep(1000);
                startTime = new Date(System.currentTimeMillis());
                System.out.println("更新当前时间为：" + startTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    public static void tenDown() throws InterruptedException {

        int num = 10;
        while (true){
            Thread.sleep(2000);
            System.out.println(num--);
            if(num == 0){
                break;
            }
        }

    }


}
