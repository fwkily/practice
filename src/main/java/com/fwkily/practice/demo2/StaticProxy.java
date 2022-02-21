package com.fwkily.practice.demo2;


/**
 * 静态代理模式总结：
 * 代理对象和真实对象都要实现同一个接口
 * 代理对象要代理真实角色
 *
 * 静态代理模式好处：
 * 代理对象可以做真实对象做不了的事情
 * 真实对象专注做着自己的事情
 */
public class StaticProxy {


    public static void main(String[] args) {

//        //自己做，不使用代理
//        You you = new You();
//        you.happyMarry();
//
//        //交给代理对象做
//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.happyMarry();

        new Thread(() -> System.out.println("我爱你")).start();

        new WeddingCompany(new You()).happyMarry();
    }

}

interface Marry{

    void happyMarry();

}

class You implements Marry{
    @Override
    public void happyMarry() {

        System.out.println("fwk要结婚了！开心！");

    }

}

class WeddingCompany implements Marry{

    //代理的真实对象
    private Marry target;



    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();//真实对象做的事情
        after();
    }

    public void before(){
        System.out.println("结婚前，布置现场！");
    }


    public void after(){
        System.out.println("结婚后，收尾款！");
    }

}
