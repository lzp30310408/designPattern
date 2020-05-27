package com.zhaopengLiu.iteratorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * data: 2020年05月26日
 * author: zhaopengLiu
 * description: 迭代器模式
 */
public class IteratorPatternTest {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("123");
        aggregate.add("456");
        aggregate.add("789");
        Iterator iterator = aggregate.getIterator();
        System.out.println(iterator.first());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("========");
        Iterator iterator1 = aggregate.getIterator();
        System.out.println(iterator1.first());
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}

/**
 * 抽象聚合类
 */
interface Aggregate {
    public void add(Object o);
    public void remove(Object o);
    public Iterator getIterator();
}

/**
 * 具体聚合类
 */
class ConcreteAggregate implements Aggregate {

    public List<Object> objectList = new ArrayList<>();

    @Override
    public void add(Object o) {
        objectList.add(o);
    }

    @Override
    public void remove(Object o) {
        objectList.remove(o);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(objectList);
    }
}

/**
 * 抽象迭代器
 */
interface Iterator {
    public Object first();
    public Object next();
    public boolean hasNext();
}

class ConcreteIterator implements Iterator {

    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> objectList) {
        this.list = objectList;
    }

    @Override
    public Object first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public Object next() {
        if(hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < (list.size() -1);
    }
}
