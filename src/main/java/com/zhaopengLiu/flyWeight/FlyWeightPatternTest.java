package com.zhaopengLiu.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * data: 2020年05月18日
 * author: zhaopengLiu
 * description: 享元模式
 */
public class FlyWeightPatternTest {

    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight f1 = factory.getFlyWeight("a");
        FlyWeight f2 = factory.getFlyWeight("a");
        FlyWeight f3 = factory.getFlyWeight("b");
        FlyWeight f4 = factory.getFlyWeight("c");
        FlyWeight f5 = factory.getFlyWeight("b");
        f1.operate(new UnsharedConcreteFlyWeight("第一次调用a"));
        f2.operate(new UnsharedConcreteFlyWeight("第一次调用a"));
        f3.operate(new UnsharedConcreteFlyWeight("第一次调用b"));
        f4.operate(new UnsharedConcreteFlyWeight("第一次调用c"));
        f5.operate(new UnsharedConcreteFlyWeight("第一次调用b"));
    }
}

class UnsharedConcreteFlyWeight {
    private String info;

    UnsharedConcreteFlyWeight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}


interface FlyWeight {

    public void operate(UnsharedConcreteFlyWeight unsharedConcreteFlyWeight);
}

class ConcreteFlyWeight implements FlyWeight {

    private String key;

    ConcreteFlyWeight(String key) {
       this.key = key;
        System.out.println("具体享元" + key + "模式被创建");
    }

    @Override
    public void operate(UnsharedConcreteFlyWeight unsharedConcreteFlyWeight) {
        System.out.println("具体享元" + key + "模式被调用");
        System.out.println("非享元信息是" + unsharedConcreteFlyWeight.getInfo());
    }
}

class FlyWeightFactory {

    private Map<String, FlyWeight> flyWeightMap = new HashMap<>();

    public FlyWeight getFlyWeight(String key) {
        FlyWeight flyWeight = flyWeightMap.get(key);
        if(null != flyWeight) {
            System.out.println("具体享元" + key + "对象已存在");
        } else {
            flyWeight = new ConcreteFlyWeight(key);
            flyWeightMap.put(key, flyWeight);
        }
        return flyWeight;
    }

}