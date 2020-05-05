package com.zhaopengLiu.singletonPattern;

/**
 * data: 2020年05月05日
 * author: zhaopengLiu
 * description: 静态内部类创建对象
 */
public class Singleton {

    private Singleton() {}

    /**
     * 静态内部类包含实例
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 通过静态内部类的方式创建对象，实现简单，只适合于静态域，调用时才占用内存
     * @return 实例
     */
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
