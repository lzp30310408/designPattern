package com.zhaopengLiu.singletonPattern;

/**
 * data: 2020年05月05日
 * author: zhaopengLiu
 * description: 双检式创建单例实例
 */
public class DoubleCheck {

    private static DoubleCheck instance;

    private DoubleCheck() {}


    /**
     * 结合懒汉式和饿汉式的共同点，即做到了可以线程安全，又对内存空间上的占用较少
     * @return 实例
     */
    public static DoubleCheck getInstance() {
       if(instance == null) {
           synchronized (DoubleCheck.class) {
               if(instance == null) {
                   instance = new DoubleCheck();
               }
           }
       }
       return instance;
    }


}
