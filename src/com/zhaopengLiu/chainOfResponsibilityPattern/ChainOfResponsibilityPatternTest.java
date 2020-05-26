package com.zhaopengLiu.chainOfResponsibilityPattern;

/**
 * data: 2020年05月25日
 * author: zhaopengLiu
 * description: 责任链模式，职责链模式
 */
public class ChainOfResponsibilityPatternTest {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandlerA();
        handler1.handleRequest("one");
        handler1.handleRequest("two");
        System.out.println("============");
        Handler handler2 = new ConcreteHandlerA();
        handler2.setNext(new ConcreteHandlerB());
        handler2.handleRequest("two");
    }

}

/**
 * 抽象处理者
 */
abstract class Handler {

    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

/**
 * 具体处理者A
 */
class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("one".equals(request)) {
            System.out.println("具体处理者1处理请求");
            return;
        }
        if (getNext() != null) {
            getNext().handleRequest(request);
            return;
        }
        System.out.println("此请求无人受理");
    }
}

/**
 * 具体处理者B
 */
class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("two".equals(request)) {
            System.out.println("具体处理者2处理请求");
            return;
        }
        if (getNext() != null) {
            getNext().handleRequest(request);
            return;
        }
        System.out.println("此请求无人受理");
    }
}