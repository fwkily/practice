package com.fwkily.practice.proxy.staticProxy;

import com.fwkily.practice.proxy.SendMessage;
import com.fwkily.practice.proxy.SendMessageImpl;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:17 2021/12/7
 */
public class Test {

    public static void main(String[] args) {
        SendMessage sendMessage = new SendMessageImpl();
        SendMessageProxy sendMessageProxy = new SendMessageProxy(sendMessage);
        sendMessageProxy.send("你好，world！");
    }

}
