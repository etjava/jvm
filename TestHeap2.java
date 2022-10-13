package com.etjava;

/*
测试堆内存查看工具
jps 查看Java进程ID
jmap -heap java进程ID   查看某个进程某个时间段的堆内存使用状态
jconcole 图形化的 可以实时监测堆内存使用情况
 */
public class TestHeap2 {
    public static void main(String[] args) throws Exception {
        System.out.println("1............");
        Thread.sleep(30000); // 休眠30秒 为了查看堆内存使用情况
        int[] data = new int[1024*1024*10]; // 10M大小的int数组 会在堆内存中开辟10m的空间出来
        System.out.println("2............");
        Thread.sleep(20000);// 休眠10秒 更好的观察堆内存使用情况
        System.out.println("3............");
        data = null; // 滞空数据
        System.gc(); // 触发垃圾回收机制
        Thread.sleep(60000*5); // 休眠5分钟 为了观察堆内存使用情况
    }
}
