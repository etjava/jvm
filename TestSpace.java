package com.etjava;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/*
方法区内存溢出
8.0 调整大小 为了演示方法区溢出
-XX:MaxMetaspaceSize=8m -XX:MaxMetaspaceSize=10m -XX:-UseCompressedOops

方法区是用来存放类的结构 这里为了演示方法区溢出 模拟一个类加载器

6.0 调整方法区大小
-XX:MaxPermSize=8m
 */
public class TestSpace extends ClassLoader{

    public static void main(String[] args) {
        int count = 0;
        try {
            TestSpace t = new TestSpace();
            for(int i=0;i<20000;i++,count++){
                // 生成类的二进制字节码
                ClassWriter c = new ClassWriter(i);
                // 版本号，方法修饰符，类名，包名，父类，接口
                c.visit(Opcodes.V1_6,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);

                byte[] code = c.toByteArray();
                // 执行类的加载
                t.defineClass("Class"+i,code,0,code.length);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(count);
        }
    }
}
