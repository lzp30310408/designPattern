package com.zhaopengLiu.builderPattern;

/**
 * data: 2020年05月16日
 * author: zhaopengLiu
 * description:  指挥者
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 构造产品
     * @return 产品
     */
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
