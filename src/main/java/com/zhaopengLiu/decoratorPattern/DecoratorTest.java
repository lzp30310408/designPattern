package com.zhaopengLiu.decoratorPattern;

/**
 * data: 2020年05月17日
 * author: zhaopengLiu
 * description: 装饰模式
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Target target = new TargetRealize();
        Decorator decorator = new ConcreteDecorator(target);
        decorator.operate();
    }
}

/**
 * 抽象构件
 */
interface Target {

    void operate();
}

/**
 * 具体构件
 */
class TargetRealize implements Target{

    @Override
    public void operate() {
        System.out.println("加入具体构件");
    }
}

/**
 * 抽象装饰
 */
class Decorator implements Target{

    protected Target target;

    public Decorator(Target target) {
        this.target = target;
    }

    @Override
    public void operate(){
        target.operate();
    }
}

/**
 * 具体装饰
 */
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Target target) {
        super(target);
    }

    @Override
    public void operate() {
        super.operate();
        addedFunction();
    }

    /**
     * 增加额外的功能
     */
    private void addedFunction() {
        System.out.println("增加额外功能");
    }
}


