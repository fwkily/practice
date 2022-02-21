package com.fwkily.practice.proxy;

import lombok.Data;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:15 2021/12/7
 */
@Data
public class SendMessageImpl implements SendMessage{
    @Override
    public String send(String s) {
        System.out.println("发送的消息：" + s);
        return s;
    }

}
