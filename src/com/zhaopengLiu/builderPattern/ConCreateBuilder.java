package com.zhaopengLiu.builderPattern;

/**
 * data: 2020年05月16日
 * author: zhaopengLiu
 * description:
 */
public class ConCreateBuilder extends Builder {
    @Override
    public void buildPartA() {
        System.out.println("建造PartA");
    }

    @Override
    public void buildPartB() {
        System.out.println("建造PartB");
    }

    @Override
    public void buildPartC() {
        System.out.println("建造PartC");
    }
}
