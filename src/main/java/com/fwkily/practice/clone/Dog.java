package com.fwkily.practice.clone;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:36 2021/12/3
 */
@Data
public class Dog implements Cloneable, Serializable {

    private Integer age;

    private int[] num;

    private Cat cat;

    private String address;

    private BigDecimal price;

    private Integer school;

    @Override
    public Dog clone(){
        Dog dog = null;
        try {
            dog = (Dog) super.clone();
//            int[] num = dog.getNum();
//            int[] num1 = new int[num.length];
//            System.arraycopy(num, 0, num1, 0, num.length);
//            dog.setNum(num1);
//            Cat cat = new Cat(dog.getCat().getName());
//            dog.setCat(cat);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return dog;
    }


}
