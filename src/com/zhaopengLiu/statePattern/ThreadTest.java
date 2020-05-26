package com.zhaopengLiu.statePattern;

/**
 * data: 2020年05月26日
 * author: zhaopengLiu
 * description: 用状态模式设计一个多线程的状态转换过程
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadContext tc = new ThreadContext();
        tc.start();
        tc.getCpu();
        tc.suspend();
        tc.resume();
        tc.stop();
    }
}

/**
 * 线程环境类（线程上下文）
 */
class ThreadContext {

    private ThreadState threadState;

    public ThreadContext() {
        threadState = new New();
    }

    public ThreadState getThreadState() {
        return threadState;
    }

    public void setThreadState(ThreadState threadState) {
        this.threadState = threadState;
    }

    public void start() {
        ((New)threadState).start(this);
    }

    public void getCpu() {
        ((Runnable)threadState).getCpu(this);
    }

    public void suspend() {
        ((Running)threadState).suspend(this);
    }

    public void resume() {
        ((Blocked)threadState).resume(this);
    }

    public void stop() {
        ((Running)threadState).stop(this);
    }

}


/**
 * 抽象线程状态类
 */
abstract class ThreadState {

    protected String stateName;
}

/**
 * 新建线程
 */
class New extends ThreadState {

    public New() {
        stateName = "新建状态";
        System.out.println("线程当前处于新建状态");
    }

    public void start(ThreadContext tc) {
        System.out.print("线程启动-->");
        if("新建状态".equals(stateName)) {
            tc.setThreadState(new Runnable());
        } else {
            System.out.println("线程不是新建状态，无法调用start()方法");
        }
    }

}

/**
 * 就绪状态
 */
class Runnable extends ThreadState {

    public Runnable() {
        stateName = "就绪状态";
        System.out.println("线程当前处于就绪状态");
    }

    public void getCpu(ThreadContext tc) {
        System.out.print("获得CPU-->");
        if("就绪状态".equals(stateName)) {
            tc.setThreadState(new Running());
        } else {
            System.out.println("当前线程不是就绪状态，无法获取cpu");
        }
    }
}

/**
 * 运行状态
 */
class Running extends ThreadState {
    public Running() {
        stateName = "运行状态";
        System.out.println("线程当前处于运行状态");
    }

    public void suspend(ThreadContext tc) {
        System.out.print("调用suspend方法-->");
        if("运行状态".equals(stateName)) {
            tc.setThreadState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，无法调用suspend方法");
        }
    }

    public void stop(ThreadContext tc) {
        System.out.print("调用停止方法-->");
        if("运行状态".equals(stateName)) {
            tc.setThreadState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，无法调用stop方法");
        }
    }
}

/**
 * 阻塞状态
 */
class Blocked extends ThreadState {
    public Blocked() {
        stateName = "阻塞状态";
        System.out.println("当前线程处于阻塞状态");
    }

    public void resume(ThreadContext tc) {
        System.out.print("调用resume方法-->");
        if("阻塞状态".equals(stateName)) {
            tc.setThreadState(new Running());
        } else {
            System.out.println("当前线程不是阻塞状态，无法调用resume方法");
        }
    }
}

/**
 * 死亡状态
 */
class Dead extends ThreadState {
    public Dead() {
        stateName = "死亡状态";
        System.out.println("当前线程处于死亡状态");
    }
}
