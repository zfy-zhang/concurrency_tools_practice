package com.pat.flowcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project Name: concurrency_tools_practice
 * File Name: CountDownLatchDemo2
 * Package Name: com.pat.flowcontrol.countdownlatch
 * Author: elisha
 * Date: 2020/4/17 18:44
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch beginLatch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = i+ 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + no + "准备完毕，等待发令枪");
                    try {
                        beginLatch.await();
                        System.out.println("No." + no + "开始跑步了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.submit(runnable);
        }
        //裁判员检查发令枪...
        Thread.sleep(1000);
        System.out.println("发令枪响，比赛开始！");
        beginLatch.countDown();

    }
}
