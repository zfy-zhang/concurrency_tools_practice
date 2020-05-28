package com.pat.lock.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project Name: concurrency_tools_practice
 * File Name: TryLockDeadlock
 * Package Name: com.pat.lock.lock
 * Author: elisha
 * Date: 2020/3/25 9:27
 * Copyright (c) 2020,All Rights Reserved.
 * Description：用tryLock来避免死锁
 */
public class TryLockDeadlock implements Runnable{
    int flag = 1;
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        TryLockDeadlock tryLockDeadlock1 = new TryLockDeadlock();
        TryLockDeadlock tryLockDeadlock2 = new TryLockDeadlock();
        tryLockDeadlock1.flag = 1;
        tryLockDeadlock2.flag = 0;
        new Thread(tryLockDeadlock1).start();
        new Thread(tryLockDeadlock2).start();
    }

    @Override
    public void run() {
        if (flag == 1) {
            try {
                if (lock1.tryLock(800, TimeUnit.MICROSECONDS)) {
                    try{
                        System.out.println("线程1获取到了锁1！");
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("线程1获取到锁2！");
                                System.out.println("线程1成功获取到了两把锁！");
                            }finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("线程1获取锁2失败，已重试！");
                        }
                    }finally {
                        lock1.unlock();
                        Thread.sleep(new Random().nextInt(1000));
                    }
                }else {
                    System.out.println("线程1获取锁1失败，已重试！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (flag == 0) {
            try {
                if (lock2.tryLock(3000, TimeUnit.MILLISECONDS)) {
                    try{
                        System.out.println("线程2获取到了锁2！");
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("线程2获取到锁1！");
                                System.out.println("线程2成功获取到了两把锁！");
                            }finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("线程2获取锁1失败，已重试！");
                        }
                    }finally {
                        lock2.unlock();
                        Thread.sleep(new Random().nextInt(1000));
                    }
                }else {
                    System.out.println("线程2获取锁2失败，已重试！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}