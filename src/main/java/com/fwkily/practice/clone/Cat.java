package com.fwkily.practice.clone;

import lombok.Data;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:45 2021/12/3
 */
@Data
public class Cat implements Cloneable {

    private String name;

    private int age;

    public Cat(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    protected Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
