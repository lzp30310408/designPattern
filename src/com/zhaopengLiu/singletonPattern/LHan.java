package com.zhaopengLiu.singletonPattern;

/**
 * data: 2020年05月05日
 * author: zhaopengLiu
 * description: 懒汉式单例
 */
public class LHan {

    private LHan() {}  // 私有构造方法，防止调用

    private static LHan instance; // 懒汉式

    /**
     * 获取实例的方法，例如Calendar实例(多线程存在问题) static为null时，两个线程同时调用getInstance，会获取到两个新对象
     * @return 实例
     */
    public static LHan getInstance() {
        if(instance == null) {
            instance = new LHan();
        }
        return instance;
    }

    /**
     * 多线程获取实例的方法，用synchronized关键字来
     * @return 实例
     */
    public synchronized static LHan getThreadInstance() {
        if(instance == null) {
            instance = new LHan();
        }
        return instance;
    }


}
