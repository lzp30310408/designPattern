package com.zhaopengLiu.abstractFactoryPattern;

/**
 * data: 2020年05月11日
 * author: zhaopengLiu
 * description: 抽象产品族，所有继承产品族都必须生产该产品的电视和冰箱
 */
public interface AbstractProduct {

    void tel();

    void box();
}


class Product1 implements AbstractProduct {

    @Override
    public void tel() {
        System.out.println("我是产品1的电视");
    }

    @Override
    public void box() {
        System.out.println("我是产品1的冰箱");
    }
}

class Product2 implements AbstractProduct {

    @Override
    public void tel() {
        System.out.println("我是产品2的电视");
    }

    @Override
    public void box() {
        System.out.println("我是产品2的冰箱");
    }
}