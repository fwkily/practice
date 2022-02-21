package com.fwkily.practice.testThread;

import java.util.Date;

public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s){
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start Time" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "end Time" + new Date());

    }

    public void processCommand(){
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
