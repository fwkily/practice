package com.fwkily.practice.leetcode;

import java.util.Stack;

/**
 * @Author: fuwk
 * @Description:
 * @Date: 15:01 2021/12/8
 */
public class CQueue {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.deleteHead();
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public int appendTail(int value){
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return stack1.push(value);
    }

    public int deleteHead(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            return -1;
        }else {
            return stack2.pop();
        }
    }


}
