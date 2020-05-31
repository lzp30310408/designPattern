package com.zhaopengLiu.adaptPattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description:  类适配器(继承)
 */
public interface TargetClass {

    void request();

}


/**
 * 适配者
 */
class Adapter {

    public void specialRequest() {
        System.out.println("适配者业务开始工作");
    }

}

/**
 * 适配器
 */
class ClassAdapt extends Adapter implements TargetClass {

    /**
     * 适配器工作
     */
    @Override
    public void request() {
        System.out.println("适配器开始工作");
        specialRequest();
    }
}

class ClassAdaptTest {

    public static void main(String[] args) {
        TargetClass targetClass = new ClassAdapt();
        targetClass.request();
    }
}

