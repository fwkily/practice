package com.fwkily.practice.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 17:20 2021/12/7
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);

        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }

}
