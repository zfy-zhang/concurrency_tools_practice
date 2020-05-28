package com.pat.threadlocal;

/**
 * Project Name: concurrency_tools_practice
 * File Name: ThreadLocalNormalUsage07
 * Package Name: com.pat.threadlocal
 * Author: elisha
 * Date: 2020/3/24 14:30
 * Copyright (c) 2020,All Rights Reserved.
 * Description：演示ThreadLocal用法2：避免传递参数的麻烦
 */
public class ThreadLocalNormalUsage07 {
    public static void main(String[] args) {
        new Service1().process("");
    }
}

class Service1 {

    public void process(String name) {
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {

    public void process() {
        User user = UserContextHolder.holder.get();
        ThreadSafeFormatter.threadLocal.get();
        System.out.println("Service2拿到用户名：" + user.name);
        new Service3().process();
    }
}

class Service3 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {

    public static ThreadLocal<User> holder = new ThreadLocal<>();

}

class User {

    String name;
    public User(String name) {
        this.name = name;
    }
}