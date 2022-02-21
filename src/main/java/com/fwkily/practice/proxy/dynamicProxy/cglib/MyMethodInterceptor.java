package com.fwkily.practice.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 17:18 2021/12/7
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("方法后");
        return result;
    }
}
