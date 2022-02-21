package com.fwkily.practice.clone;

import java.math.BigDecimal;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:36 2021/12/3
 */
public class TestDeepClone {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.setAge(100);
        dog.setNum(new int[]{1000});
        dog.setCat(new Cat("猫神",11));
        dog.setAddress("湖北省");
        dog.setPrice(new BigDecimal("5"));
        dog.setSchool(44);

        System.out.println("克隆前：" + dog);

//        Dog dog1 = dog;
        Dog dog1 = dog.clone();
//        Dog dog1 = util.clone(dog);

        Integer age = dog.getAge();
        age = 65533;
        dog1.setAge(age);
//        Cat cat = dog.getCat();
//        cat.setName("老鼠");
//        cat.setAge(22);
        dog1.setCat(dog.getCat().clone());
        int[] num = dog.getNum();
        num[0] = 33;
        dog1.setNum(num);
        BigDecimal price = dog.getPrice();
        BigDecimal bigDecimal = price.subtract(BigDecimal.TEN);
        dog1.setPrice(bigDecimal);
        Integer school = dog.getSchool();
        school = 88;
        dog1.setSchool(school);

        System.out.println("克隆后：" + dog1);

        System.out.println("源对象克隆后：" + dog);


    }



}
