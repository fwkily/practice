package com.fwkily.practice.proxy.dynamicProxy.cglib;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 17:46 2021/12/7
 */
public class SayHello {

    public String say(String s){
        System.out.println(s);
        return s;
    }
}
