package com.fwkily.practice.clone;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:36 2021/12/3
 */
public class TestShadowClone {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.setAge(100);
        dog.setNum(new int[]{1000});
//        dog.setCat(new Cat("猫神"));

        System.out.println("克隆前：" + dog.toString());

        Dog dog1 = dog.clone();

//        dog1.setAge(50);
//        dog1.setNum(new int[]{99});

        System.out.println("克隆后：" + dog1);

    }

}
