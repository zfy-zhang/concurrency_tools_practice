package com.pat.lock.reentranlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Project Name: concurrency_tools_practice
 * File Name: RecursionDemo
 * Package Name: com.pat.lock.reentranlock
 * Author: elisha
 * Date: 2020/3/26 10:40
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class RecursionDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        accessResource();
    }

    private static void accessResource() {
        lock.lock();
        try {
            System.out.println("已经对资源进行处理！");
            if (lock.getHoldCount() < 5) {
                System.out.println(lock.getHoldCount());
                accessResource();
                System.out.println(lock.getHoldCount());
            }
        } finally {
            lock.unlock();
        }
    }
}
