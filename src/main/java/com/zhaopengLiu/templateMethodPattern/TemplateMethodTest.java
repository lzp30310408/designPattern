package com.zhaopengLiu.templateMethodPattern;

/**
 * data: 2020年05月24日
 * author: zhaopengLiu
 * description: 模板方法
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        Parent parent = new Children();
        parent.templateMethod();
        System.out.println("============");
        AbstractHookClass hookClass = new ConcreteHookClass();
        hookClass.templateMethod();
        System.out.println("============");
        AbstractHookClass hookClass1 = new OtherConcreteHookClass();
        hookClass1.templateMethod();
    }

}

/**
 * 抽象模板方法
 */
abstract class Parent {

    public void templateMethod() {
        specialMethod();
        templateMethod1();
        templateMethod2();
    }

    public void specialMethod() {
        System.out.println("特殊方法");
    }

    public abstract void templateMethod1();

    public abstract void templateMethod2();

}

/**
 * 具体方法
 */
class Children extends Parent {

    @Override
    public void templateMethod1() {
        System.out.println("模板方法1的具体方法");
    }

    @Override
    public void templateMethod2() {
        System.out.println("模板方法2的具体方法");
    }
}