package com.pat.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project Name: concurrency_tools_practice
 * File Name: MustUnlock
 * Package Name: com.pat.lock.lock
 * Author: elisha
 * Date: 2020/3/25 9:54
 * Copyright (c) 2020,All Rights Reserved.
 * Description：Lock不会像synchronized一样，异常的时候自动释放锁，所以最佳实践是，finally中释放锁，以便保证发生异常的时候锁一定被释放
 */
public class MustUnlock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "开始执行任务");
        } finally {
            lock.unlock();
        }
    }
}
