package com.fwkily.practice.proxy.staticProxy;

import com.fwkily.practice.proxy.SendMessage;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:15 2021/12/7
 */
public class SendMessageProxy implements SendMessage {

    private final SendMessage sendMessage;

    public SendMessageProxy(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    @Override
    public String send(String s) {
        beforeSend();
        sendMessage.send(s);
        afterSend();
        return s;
    }


    private void afterSend() {
        System.out.println("发消息之后！");
    }

    private void beforeSend() {
        System.out.println("发消息之前！");
    }

}
