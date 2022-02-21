package com.fwkily.practice.proxy.dynamicProxy.jdkDynamic;

import com.fwkily.practice.proxy.SendMessage;
import com.fwkily.practice.proxy.SendMessageImpl;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 16:02 2021/12/7
 */
public class ProxyTest {

    public static void main(String[] args) {
        SendMessage sendMessage = new SendMessageImpl();
        SendMessage proxy = (SendMessage) JDKProxyFactory.getProxy(sendMessage);
        proxy.send("执行。。。。");
    }

}
