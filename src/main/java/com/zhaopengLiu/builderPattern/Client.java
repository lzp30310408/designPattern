package com.zhaopengLiu.builderPattern;

/**
 * data: 2020年05月16日
 * author: zhaopengLiu
 * description: 客户端
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConCreateBuilder();
        Director director = new Director(builder);
        Product construct = director.construct();
        construct.show();
    }

}

