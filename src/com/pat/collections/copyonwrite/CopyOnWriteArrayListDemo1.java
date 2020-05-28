package com.pat.collections.copyonwrite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Project Name: concurrency_tools_practice
 * File Name: CopyOnWriteArrayListDemo1
 * Package Name: com.pat.collections.copyonwrite
 * Author: elisha
 * Date: 2020/4/14 16:04
 * Copyright (c) 2020,All Rights Reserved.
 * Description：演示CopyOnWriteArrayList可以在迭代的过程中修改数组内容，但是ArrayList不行，对比
 */
public class CopyOnWriteArrayListDemo1 {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");


        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("list" + list);
            String next = iterator.next();
            System.out.println(next);

            if (next.equals("2")) {
                list.remove("5");
            }
            if (next.equals("4")) {
                list.add("4 found");
            }
        }


    }
}
