package com.etjava;

/**
 * 体会虚拟机栈中方法执行顺序  先进后出
 */
public class Test {

    public static void main(String[] args) {
        int a = 0;

        int b = 1;

        method(a,b);
    }

    private static void method(int a, int b) {

        a+=10;
        b+=20;
        method2(a,b);
    }

    private static void method2(int a, int b) {
        int c = a+b;
        System.out.println(c);
    }
}