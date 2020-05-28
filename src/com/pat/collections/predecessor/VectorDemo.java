package com.pat.collections.predecessor;

import java.util.Vector;

/**
 * Project Name: concurrency_tools_practice
 * File Name: VectorDemo
 * Package Name: com.pat.collections.predecessor
 * Author: elisha
 * Date: 2020/4/13 10:25
 * Copyright (c) 2020,All Rights Reserved.
 * Description：演示Vector
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("不才人");
        System.out.println(vector.get(0));
    }
}
