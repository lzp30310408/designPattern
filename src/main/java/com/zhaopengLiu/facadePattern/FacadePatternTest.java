package com.zhaopengLiu.facadePattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description: 外观模式
 */
public class FacadePatternTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operate();
    }
}

/**
 * 子系统1
 */
class Object1 {

    public void operate() {
        System.out.println("Object1.Operate");
    }
}

/**
 * 子系统2
 */
class Object2 {

    public void operate() {
        System.out.println("Object2.Operate");
    }
}

/**
 * 子系统3
 */
class Object3 {

    public void operate() {
        System.out.println("Object3.Operate");
    }
}

/**
 * 外观类
 */
class Facade {

    private final Object1 object1 = new Object1();
    private final Object2 object2 = new Object2();
    private final Object3 object3 = new Object3();


    public void operate() {
        object1.operate();
        object2.operate();
        object3.operate();
    }
}
