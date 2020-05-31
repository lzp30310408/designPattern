package com.zhaopengLiu.strategyPattern;

/**
 * data: 2020年05月24日
 * author: zhaopengLiu
 * description: 策略模式
 */
public class StrategyPatternTest {

    public static void main(String[] args) {
        Context c = new Context();
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        c.setStrategy(strategyB);
        c.strategyMethod();
    }
}

interface Strategy {
    public void strategyMethod();
}

class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("策略方法1被执行");
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("策略方法2被执行");
    }
}

class Context {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
