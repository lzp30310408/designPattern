package com.zhaopengLiu.singletonPattern;

/**
 * data: 2020年05月05日
 * author: zhaopengLiu
 * description:
 */
public class Ehan {

    private Ehan() {}

    private static Ehan instance = new Ehan(); // 实例初始化的时候已经创建好了

    /**
     * 饿汉式获取实例，初始化的时候已经构建完毕，比较浪费资源 不管有没有调用都会占用堆内存
     * @return 实例
     */
    public static Ehan getInstance() {
        return instance;
    }

}
