package com.zhaopengLiu.mementoPattern;

/**
 * data: 2020年05月28日
 * author: zhaopengLiu
 * description: 备忘录模式
 */
public class MementoPatternTest {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("S0");
        System.out.println("初始状态:" + originator.getState());
        careTaker.setMemento(originator.createMemento());
        originator.setState("S1");
        System.out.println("修改后状态：" + originator.getState());
        originator.restoreMemento(careTaker.getMemento());
        System.out.println("恢复后状态：" + originator.getState());
    }
}

/**
 * 备忘录类
 */
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

/**
 * 发起人
 */
class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        setState(memento.getState());
    }
}

/**
 * 管理类
 */
class CareTaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}