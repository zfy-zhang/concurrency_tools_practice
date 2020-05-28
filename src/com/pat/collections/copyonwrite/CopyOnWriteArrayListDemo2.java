package com.pat.collections.copyonwrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Project Name: concurrency_tools_practice
 * File Name: CopyOnWriteArrayListDemo2
 * Package Name: com.pat.collections.copyonwrite
 * Author: elisha
 * Date: 2020/4/14 19:01
 * Copyright (c) 2020,All Rights Reserved.
 * Description：对比两个迭代器
 */
public class CopyOnWriteArrayListDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});

        System.out.println(list);

        Iterator<Integer> itr1 = list.iterator();

        list.remove(2);
        Thread.sleep(1000);
        System.out.println(list);

        Iterator<Integer> itr2 = list.iterator();

        itr1.forEachRemaining(System.out::println);
        itr2.forEachRemaining(System.out::println);

    }
}
