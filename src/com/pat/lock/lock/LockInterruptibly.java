package com.pat.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project Name: concurrency_tools_practice
 * File Name: LockInterruptibly
 * Package Name: com.pat.lock.lock
 * Author: elisha
 * Date: 2020/3/25 11:11
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class LockInterruptibly implements Runnable {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptibly lockInterruptibly= new LockInterruptibly();
        Thread t1 = new Thread(lockInterruptibly);
        Thread t2 = new Thread(lockInterruptibly);
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁！");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到锁！");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "睡眠期间被中断了！");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁！");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "获得锁期间被中断！");
        }
    }
}
