package com.zhaopengLiu.interpreterPattern;

/**
 * data: 2020年05月29日
 * author: zhaopengLiu
 * description: 解释器模式
 */
public class InterpreterPatternTest {

    public static void main(String[] args) {

    }
}

/**
 * 抽象表达式类
 */
interface AbstractExpression {
    public Object interpret(String info);
}

/**
 * 终结符表达式类
 */
class TerminalExpression implements AbstractExpression {

    @Override
    public Object interpret(String info) {
        return null;
    }
}

/**
 * 非终结符表达式类
 */
class NonTerminalExpression implements AbstractExpression {

    private AbstractExpression expression1;
    private AbstractExpression expression2;

    @Override
    public Object interpret(String info) {
        return null;
    }
}

/**
 * 环境类
 */
class Context {

    private AbstractExpression expression;

    public void operate(String info) {

    }
}