package com.pat.collections.predecessor;

import java.util.Hashtable;

/**
 * Project Name: concurrency_tools_practice
 * File Name: HashTableDemo
 * Package Name: com.pat.collections.predecessor
 * Author: elisha
 * Date: 2020/4/13 10:28
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("不才人", 26);
        System.out.println(hashtable.get("不才人"));
    }
}
