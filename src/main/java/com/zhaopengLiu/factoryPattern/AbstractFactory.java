package com.zhaopengLiu.factoryPattern;

/**
 * data: 2020年05月08日
 * author: zhaopengLiu
 * description: 抽象工厂，提供标准
 */
public interface AbstractFactory {

    AbstractProduct getProduct();
}

class Factory1 implements AbstractFactory{


    @Override
    public AbstractProduct getProduct() {
        return new Product1();
    }
}


class Factory2 implements AbstractFactory {

    @Override
    public AbstractProduct getProduct() {
        return new Product2();
    }
}