package com.pat.lock.reentranlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Project Name: concurrency_tools_practice
 * File Name: GetHoldCountDemo
 * Package Name: com.pat.lock.reentranlock
 * Author: elisha
 * Date: 2020/3/26 10:45
 * Copyright (c) 2020,All Rights Reserved.
 * Description：获取已获得的锁的数量
 */
public class GetHoldCountDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
}
