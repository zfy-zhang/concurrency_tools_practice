package com.pat.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project Name: concurrency_tools_practice
 * File Name: ThreadLocalDemo1
 * Package Name: com.pat.threadlocal
 * Author: elisha
 * Date: 2020/3/24 14:03
 * Copyright (c) 2020,All Rights Reserved.
 * Description：两个线程打印日期
 */
public class ThreadLocalDemo1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalDemo1().data(20);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalDemo1().data(200000);
                System.out.println(date);
            }
        }).start();
    }
    public String data(int s) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
