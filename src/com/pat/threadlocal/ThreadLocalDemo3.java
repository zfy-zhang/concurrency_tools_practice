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
 * Description：1000个打印日期的任务，用线程池来执行
 */
public class ThreadLocalDemo3 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalDemo3().data(finalI);
                    System.out.println(date);
                }
            });
        }
        executorService.shutdown();
    }
    public String data(int s) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
