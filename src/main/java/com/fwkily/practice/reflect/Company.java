package com.fwkily.practice.reflect;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 9:34 2021/12/8
 */
public class Company {

    private String name;

    Company(){
        this.name = "李四";
    }

    public void publicMethod(String name){
        System.out.println("公共方法" + this.name);
    }


    public void privateMethod(String name){
        System.out.println("私有方法" + name);
    }

}
