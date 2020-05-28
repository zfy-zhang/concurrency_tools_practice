package com.pat.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project Name: concurrency_tools_practice
 * File Name: ThreadLocalDemo2
 * Package Name: com.pat.threadlocal
 * Author: elisha
 * Date: 2020/3/24 14:07
 * Copyright (c) 2020,All Rights Reserved.
 * Description：解决线程安全问题
 */
public class ThreadLocalDemo5 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalDemo5().data(finalI);
                    System.out.println(date);
                }
            });
        }
        executorService.shutdown();
    }
    public String data(int s) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * s);
        String sd = null;
        synchronized (ThreadLocalDemo5.class) {
            sd = sdf.format(date);
        }
        return sd;
    }
}
