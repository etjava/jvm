package com.etjava;

/**
 * 虚拟机栈溢出测试
 */
public class TestStack {

    static int count = 0;
    public static void main(String[] args) {
       try {
           m();
       }catch (Exception e){

           e.printStackTrace();

       }finally {
           System.out.println(count);
       }
    }

    public static void m(){
        count++;
        m();
    }
}
