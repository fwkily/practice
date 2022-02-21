package com.fwkily.practice.proxy.dynamicProxy.jdkDynamic;

import java.lang.reflect.Proxy;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 17:00 2021/12/7
 */
public class JDKProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new DebugInvocationHandler(target));
    }

}
