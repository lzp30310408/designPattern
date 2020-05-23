package com.zhaopengLiu.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * data: 2020年05月23日
 * author: zhaopengLiu
 * description: 透明组合模式
 */
public class CompositePatternTest {

    public static void main(String[] args) {
        Component c0 = new Composite();
        Component c1 = new Composite();
        Component l1 = new Left("1");
        Component l2 = new Left("2");
        Component l3 = new Left("3");
        c0.add(l1);
        c0.add(c1);
        c1.add(l2);
        c1.add(l3);
        c0.operate();
    }
}

/**
 * 组合模式抽象接口
 */
interface Component {

    public void add(Component c);

    public void remove(Component c);

    public Component getChild(int i);

    public void operate();
}

/**
 * 树叶构件（无子节点）
 */
class Left implements Component {

    private String name;

    public Left(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {
    }

    @Override
    public void remove(Component c) {
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operate() {
        System.out.println("树叶节点" + name + "被访问");
    }
}

/**
 * 树枝节点被访问
 */
class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operate() {
        for (Component child : children) {
            child.operate();
        }
    }
}

