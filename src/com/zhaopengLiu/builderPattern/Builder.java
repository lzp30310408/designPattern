package com.zhaopengLiu.builderPattern;

/**
 * data: 2020年05月16日
 * author: zhaopengLiu
 * description: 抽象建造者
 */
public abstract class Builder {

    Product product = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();


    /**
     * 获取组装后的产品
     * @return 产品
     */
    public Product getResult() {
        return product;
    }
}
