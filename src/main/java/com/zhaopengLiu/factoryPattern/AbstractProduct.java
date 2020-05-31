package com.zhaopengLiu.factoryPattern;

/**
 * data: 2020年05月08日
 * author: zhaopengLiu
 * description: 标准产品
 */
public interface AbstractProduct {

    void show();
}

class Product1 implements AbstractProduct {

    @Override
    public void show() {
        System.out.println("我是产品1");
    }
}

class Product2 implements AbstractProduct {

    @Override
    public void show() {
        System.out.println("我是产品2");
    }
}
