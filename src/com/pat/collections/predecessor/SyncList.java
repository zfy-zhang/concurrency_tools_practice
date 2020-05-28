package com.pat.collections.predecessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project Name: concurrency_tools_practice
 * File Name: SyncList
 * Package Name: com.pat.collections.predecessor
 * Author: elisha
 * Date: 2020/4/13 10:38
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class SyncList {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("pat");
        System.out.println(list.get(0));
    }
}
