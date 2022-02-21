package com.fwkily.practice.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 9:36 2021/12/8
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {
        //四种获取Class的方式
//        Class<?> aClass = Class.forName("com.fwkily.practice.reflect.Company");
        Class<?> aClass = Company.class.getClassLoader().loadClass("com.fwkily.practice.reflect.Company");
        Company company = (Company) aClass.newInstance();
//        Company company = new Company();
//        Class<? extends Company> aClass = company.getClass();
//        Class<Company> aClass = Company.class;
//        Class<?> aClass = Company.class.getClassLoader().loadClass("com.fwkily.practice.reflect.Company");
        String aClassName = aClass.getName();
        System.out.println(aClassName);
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(company, "张三");

        Method publicMethod = aClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(company, "共用方法入参");

        Method privateMethod = aClass.getDeclaredMethod("privateMethod", String.class);
        privateMethod.invoke(company, "私有方法入参");

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        System.out.println(declaredConstructor);

        Class<?>[] interfaces = aClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));


    }


}
