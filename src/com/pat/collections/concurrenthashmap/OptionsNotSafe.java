package com.pat.collections.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Project Name: concurrency_tools_practice
 * File Name: OptionsNotSafe
 * Package Name: com.pat.collections.concurrenthashmap
 * Author: elisha
 * Date: 2020/4/14 9:01
 * Copyright (c) 2020,All Rights Reserved.
 * Description：组合操作并不保证线程安全
 */
public class OptionsNotSafe implements Runnable {

    private static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        concurrentHashMap.put("pat", 77);
        Thread t1 = new Thread(new OptionsNotSafe());
        Thread t2 = new Thread(new OptionsNotSafe());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(concurrentHashMap);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            while (true) {
                Integer score = concurrentHashMap.get("pat");
                Integer newScore = score + 1;
                boolean b = concurrentHashMap.replace("pat", score, newScore);
                if (b) {
                    break;
                }
            }
        }
    }
}
