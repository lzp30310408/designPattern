package com.zhaopengLiu.templateMethodPattern;

/**
 * data: 2020年05月24日
 * author: zhaopengLiu
 * description: 抽象钩子方法
 */
public abstract class AbstractHookClass {

    public void hookMethod1() {}

    public boolean hookMethod2() {
        return false;
    }

    public void specialMethod() {
        System.out.println("特殊方法1");
    }


    public abstract void abstractMethod();

    public void templateMethod() {
        hookMethod1();
        if(hookMethod2()) {
            specialMethod();
        }
        abstractMethod();
    }
}

/**
 * 具体钩子方法
 */
class ConcreteHookClass extends AbstractHookClass {

    @Override
    public void abstractMethod() {
        System.out.println("抽象方法的具体方法被调用");
    }

    @Override
    public void hookMethod1() {
        System.out.println("钩子方法执行。。。");
    }

    @Override
    public boolean hookMethod2() {
        return true;
    }
}

class OtherConcreteHookClass extends AbstractHookClass {

    @Override
    public void hookMethod1() {
    }

    @Override
    public boolean hookMethod2() {
        return false;
    }

    @Override
    public void abstractMethod() {
        System.out.println("抽象方法的其他具体方法被调用");
    }
}
