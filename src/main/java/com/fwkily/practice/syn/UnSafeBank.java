package com.fwkily.practice.syn;

public class UnSafeBank {

    public static void main(String[] args) {

        //账户
        Account account = new Account(1000,"结婚基金");

        Drawing you = new Drawing(account,50,"你");
        Drawing girlfriend = new Drawing(account,100,"女朋友");

        you.start();
        girlfriend.start();

    }

}


//账户
class Account {
    public int money;

    public String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行
class Drawing extends Thread {
    private Account account;

    //取了多少钱
    private int drawingMoney;

    //现在手里有多少钱
    private int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    //synchronized默认锁的是this 当前对象
    public void run() {


        //锁的对象就是变化的量，需要增删改的对象
        synchronized (account){

            if(account.money - drawingMoney < 0){
                System.out.println("钱不够了，取不了！");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额 = 账户 - 取的钱
            account.money =  account.money - drawingMoney;

            //你手里的钱 = 现在的钱 + 取的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(this.getName() + "手里的钱：" + nowMoney);

        }

    }
}