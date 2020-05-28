package com.pat.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project Name: concurrency_tools_practice
 * File Name: AtomicIntegerDemo1
 * Package Name: com.pat.atomic
 * Author: elisha
 * Date: 2020/4/7 9:53
 * Copyright (c) 2020,All Rights Reserved.
 * Description：演示AtomicInteger的基本用法，对比非原子类的线程安全问题，使用了原子类之后，不需要加锁，也可以保证线程安全。
 */
public class AtomicIntegerDemo1 implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static volatile int basicCount = 0;

    public void incrementAtomic() {
        atomicInteger.getAndIncrement();
    }

    public synchronized void incrementBasic () {
        basicCount++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo1 a1 = new AtomicIntegerDemo1();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("原子类的结果：" + atomicInteger.get());
        System.out.println("普通变量的结果：" + basicCount);

    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementAtomic();
            incrementBasic();
        }
    }
}
