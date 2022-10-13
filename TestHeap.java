package com.etjava;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存溢出 - 不停的追加字符串内存
 * 需要将堆内存大小调整 方便观察报错信息
 * -Xmx8m 最大内存
 * -Xmx100m
 * -Xms8m  最小内存
 */
public class TestHeap {
    public static void main(String[] args) {
        int count = 0;
        try {
            String s = "abcd";
            List<String> list = new ArrayList<>();
            for(int i = 0;i<20;i++){
                list.add(s);
                s+=s;
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(count);
        }
    }
}
