package com.zhaopengLiu.commandPattern;

/**
 * data: 2020年05月24日
 * author: zhaopengLiu
 * description:命令模式
 */
public class CommandPatternTest {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command commandA = new ConcreteCommandA(receiver);
        Command commandB = new ConcreteCommandB(receiver);
        Invoke invoke = new Invoke();
        invoke.setCommand(commandA);
        invoke.invoke();
        System.out.println("==========");
        invoke.setCommand(commandB);
        invoke.invoke();
    }
}

class Receiver {

    public void action1() {
        System.out.println("接受者方法1被调用");
    }

    public void action2() {
        System.out.println("接受者方法2被调用");
    }

}

/**
 * 抽象命令类
 */
abstract class Command {

    protected Receiver receiver;

    public Command() {

    }

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void invoke();
}


/**
 * 调用者
 */
class Invoke {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.invoke();
    }
}

/**
 * 具体命令
 */
class ConcreteCommandA extends Command {

    public ConcreteCommandA(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void invoke() {
        System.out.println("命令A被调用");
        receiver.action1();
    }
}

/**
 * 具体命令B
 */
class ConcreteCommandB extends Command {

    public ConcreteCommandB(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void invoke() {
        System.out.println("命令B被调用");
        receiver.action2();
    }
}
