package com.zhaopengLiu.proxyPattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description: 代理测试类
 */
public class ProxyTest {

    public static void main(String[] args) {
        Subject subject = new ProxyProduct();
        subject.request();
    }
}

interface Subject {
    void request();
}

class RealProduct implements Subject {

    @Override
    public void request() {
        System.out.println("处理请求");
    }
}


class ProxyProduct implements Subject {

    private RealProduct realProduct;

    @Override
    public void request() {
        synchronized (ProxyProduct.class){
            if(realProduct == null) {
                realProduct = new RealProduct();
            }
            preRequest();
            realProduct.request();
            postRequest();
        }
    }

    public void preRequest() {
        System.out.println("处理请求之前");
    }

    public void postRequest() {
        System.out.println("处理请求之后");
    }
}