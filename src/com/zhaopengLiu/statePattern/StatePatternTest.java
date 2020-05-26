package com.zhaopengLiu.statePattern;

/**
 * data: 2020年05月25日
 * author: zhaopengLiu
 * description: 状态模式
 */
public class StatePatternTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateA());
        context.hanler();
        context.hanler();
        context.hanler();
        context.hanler();
        context.hanler();
    }
}

/**
 * 环境类
 */
class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void hanler() {
        this.state.handler(this);
    }
}

/**
 * 状态类
 */
abstract class State {

    public abstract void handler(Context context);
}

/**
 * 具体状态A
 */
class ConcreteStateA extends State {

    @Override
    public void handler(Context context) {
        System.out.println("当前为状态A,切换");
        context.setState(new ConcreteStateB());
    }
}

/**
 * 具体状态B
 */
class ConcreteStateB extends State {

    @Override
    public void handler(Context context) {
        System.out.println("当前为状态B,切换");
        context.setState(new ConcreteStateA());
    }
}