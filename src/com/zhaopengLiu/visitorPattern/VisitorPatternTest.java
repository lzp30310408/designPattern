package com.zhaopengLiu.visitorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * data: 2020年05月27日
 * author: zhaopengLiu
 * description: 访问者模式
 */
public class VisitorPatternTest {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitorA = new ConcreteVisitorA();
        os.accept(visitorA);
        System.out.println("==========");
        Visitor visitorB = new ConcreteVisitorB();
        os.accept(visitorB);
    }
}

/**
 * 抽象元素类
 */
interface Element {
    void accept(Visitor visitor);
}

/**
 * 抽象访问者
 */
interface Visitor {
    void visit(ConcreteElementA a);

    void visit(ConcreteElementB b);
}

/**
 * 具体元素A
 */
class ConcreteElementA implements Element {


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operateA() {
        System.out.println("操作元素A的操作");
    }
}

/**
 * 具体元素B
 */
class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operateB() {
        System.out.println("操作元素B的操作");
    }
}

/**
 * 具体访问者A
 */
class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA a) {
        System.out.println("访问者A访问了元素A的operateA");
        a.operateA();
    }

    @Override
    public void visit(ConcreteElementB b) {
        System.out.println("访问者A访问了元素B的operateB");
        b.operateB();
    }
}

/**
 * 具体访问者B
 */
class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(ConcreteElementA a) {
        System.out.println("访问者B访问了元素A的operateA");
        a.operateA();
    }

    @Override
    public void visit(ConcreteElementB b) {
        System.out.println("访问者B访问了元素B的operateB");
        b.operateB();
    }
}

/**
 * 对象数据结构
 */
class ObjectStructure {
    private List<Element> elementList = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = elementList.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void add(Element element) {
        elementList.add(element);
    }

    public void remove(Element element) {
        elementList.remove(element);
    }

}


