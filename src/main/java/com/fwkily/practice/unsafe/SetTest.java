package com.fwkily.practice.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *同理可证 java.util.ConcurrentModificationException
 */
public class SetTest {

    public static void main(String[] args) {

        /**
         * 解决方案
         *   1.              Set<String> set = Collections.synchronizedSet(new HashSet<>());
         *   2.              Set<String> set = new CopyOnWriteArraySet<>();
         *
         *
         */

        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

        //HashSet底层就是hashmap
        //    public HashSet() {
        //        map = new HashMap<>();
        //    }

        //为什么hashset不重复
        //hashset的add方法,添加的元素就是哈市map的key，所以是不重复的
        //    public boolean add(E e) {
        //        return map.put(e, PRESENT)==null;
        //    }



    }

}
