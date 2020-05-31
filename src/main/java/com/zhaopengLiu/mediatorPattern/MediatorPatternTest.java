package com.zhaopengLiu.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * data: 2020年05月26日
 * author: zhaopengLiu
 * description: 中介模式
 */
public class MediatorPatternTest {
    public static void main(String[] args) {
        Colleague colleagueA = new ConcreteColleagueA();
        Colleague colleagueB = new ConcreteColleagueB();
        Mediator mediator = new ConcreteMediator();
        mediator.register(colleagueA);
        mediator.register(colleagueB);
        colleagueA.send();
        colleagueB.send();
        System.out.println("============");
        colleagueA.receive();
        colleagueB.receive();
    }
}

/**
 * 抽象中介者
 */
abstract class Mediator {

    public List<Colleague> colleagueList = new ArrayList<>();

    /**
     * 注册
     * @param colleague 同事类对象
     */
    public abstract void register(Colleague colleague);

    /**
     * 转发
     * @param colleague 同事类对象
     */
    public abstract void relay(Colleague colleague);
}

/**
 * 抽象同事类
 */
abstract class Colleague {

    public Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}

/**
 * 具体中介类
 */
class ConcreteMediator extends Mediator {

    @Override
    public void register(Colleague colleague) {
        if(!colleagueList.contains(colleague)) {
            colleagueList.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague ce : colleagueList) {
            if(ce != null && ce.equals(colleague)) {
                ce.receive();
            }
        }
    }
}

/**
 * 具体同事类A
 */
class ConcreteColleagueA extends Colleague {

    @Override
    public void receive() {
        System.out.println("具体同事类A接收请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类A发出请求");
        mediator.relay(this);
    }
}

/**
 * 具体同事类B
 */
class ConcreteColleagueB extends Colleague {

    @Override
    public void receive() {
        System.out.println("具体同事类B接收请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类B发出请求");
        mediator.relay(this);
    }
}
