package com.fwkily.practice.proxy.dynamicProxy.cglib;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 17:26 2021/12/7
 */
public class Test {

    public static void main(String[] args) {
        SayHello message = (SayHello) CglibProxyFactory.getProxy(SayHello.class);
        message.say("kkkkk");

    }

}
