package com.zhaopengLiu.obServerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * data: 2020年05月26日
 * author: zhaopengLiu
 * description: 观察者模式
 */
public class ObServerTest {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        ObServer obServerA = new ConcreteObServerA();
        ObServer obServerB = new ConcreteObServerB();
        subject.addObServer(obServerA);
        subject.addObServer(obServerB);
        subject.notifyObServer();
    }
}

/**
 * 抽象目标类
 */
abstract class Subject {

    public List<ObServer> obServers = new ArrayList<>();

    public void addObServer(ObServer observer) {
        obServers.add(observer);
    }

    public void removeObServer(ObServer obServer) {
        obServers.remove(obServer);
    }

    /**
     * 通知所有观察者
     */
    public abstract void notifyObServer();

}

/**
 * 具体目标
 */
class ConcreteSubject extends Subject {

    @Override
    public void notifyObServer() {
        System.out.println("具体目标发生变化");
        System.out.println("========");
        for (ObServer obServer : obServers) {
            obServer.response();
        }
    }
}

/**
 * 观察者模式
 */
interface ObServer {
    /**
     * 回应
     */
    public void response();
}

/**
 * 观察者A
 */
class ConcreteObServerA implements ObServer {

    @Override
    public void response() {
        System.out.println("具体观察者A做出反应");
    }
}

/**
 * 观察者B
 */
class ConcreteObServerB implements ObServer {


    @Override
    public void response() {
        System.out.println("具体观察者B做出反应");
    }
}
