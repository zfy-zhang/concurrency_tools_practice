package com.pat.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Project Name: concurrency_tools_practice
 * File Name: AtomicIntegerFieldUpdaterDemo
 * Package Name: com.pat.atomic
 * Author: elisha
 * Date: 2020/4/7 14:21
 * Copyright (c) 2020,All Rights Reserved.
 * Description：
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {

    static Candidate tom;
    static Candidate peter;

    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            scoreUpdater.getAndIncrement(tom);
        }
    }

    public static class Candidate {
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo atomicIntegerFieldUpdaterDemo = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(atomicIntegerFieldUpdaterDemo);
        Thread t2 = new Thread(atomicIntegerFieldUpdaterDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通变量："+peter.score);
        System.out.println("升级后的结果"+ tom.score);
    }
}
