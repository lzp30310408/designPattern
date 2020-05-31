package com.zhaopengLiu.adaptPattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description: 对象适配器（对象）
 */
public class ObjectAdapt implements TargetClass{

    private Adapter adapter;

    public ObjectAdapt(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void request() {
        System.out.println("对象适配器开始工作");
        adapter.specialRequest();
    }
}

class ObjectAdaptTest {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        TargetClass targetClass = new ObjectAdapt(adapter);
        targetClass.request();
    }
}
