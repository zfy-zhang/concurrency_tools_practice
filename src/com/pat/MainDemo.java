package com.pat;

public class MainDemo {
    private final int i1 = 200;
    private final int i2 = 200;

    public void testAdd() {
        System.out.println("i1" + System.identityHashCode(i1));
        System.out.println("i2" + System.identityHashCode(i2));
        boolean result = System.identityHashCode(i1) == System.identityHashCode(i2);
        boolean result2 = i1 == i2;
        System.out.println(result);
        System.out.println(result2);
    }

    public static void main(String[] args) {
        MainDemo mainDemo = new MainDemo();
        mainDemo.testAdd();
    }
}
