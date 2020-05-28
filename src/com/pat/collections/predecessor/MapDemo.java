package com.pat.collections.predecessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name: concurrency_tools_practice
 * File Name: MapDemo
 * Package Name: com.pat.collections.predecessor
 * Author: elisha
 * Date: 2020/4/13 13:40
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("不才人", 27);
        map.put("pat", 26);
        System.out.println(map.keySet());
        System.out.println(map.get("pat"));
        System.out.println(map.size());
        System.out.println(map.containsKey("不才人"));

    }
}
