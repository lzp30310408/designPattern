package com.zhaopengLiu.bridgePattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description: 桥接模式
 */
public class BridgeTest {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorB();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operate();
    }
}

/**
 * 实现化角色
 */
interface Implementor {
    void operateImpl();
}

/**
 * 具体实现角色A
 */
class ConcreteImplementorA implements Implementor {


    @Override
    public void operateImpl() {
        System.out.println("具体抽象化角色A被访问");
    }
}

/**
 * 具体实现角色A
 */
class ConcreteImplementorB implements Implementor {


    @Override
    public void operateImpl() {
        System.out.println("具体抽象化角色B被访问");
    }
}

/**
 *  抽象化角色
 */
abstract class Abstraction {

    protected Implementor implementor;

    protected Abstraction (Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operate();

}

class RefinedAbstraction extends Abstraction {

    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operate() {
        System.out.println("拓展抽象化角色被访问");
        implementor.operateImpl();
    }
}
