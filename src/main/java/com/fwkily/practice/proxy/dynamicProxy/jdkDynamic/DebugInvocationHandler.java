package com.fwkily.practice.proxy.dynamicProxy.jdkDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 16:00 2021/12/7
 */
public class DebugInvocationHandler implements InvocationHandler {

    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("入参:" + args[0].toString());
        Object result = method.invoke(target, args);
        System.out.println("出参：" + result);
        return result;
    }
}
