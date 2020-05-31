package com.zhaopengLiu.interpreterPattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * data: 2020年05月31日
 * author: zhaopengLiu
 * description:解释器模式代码梳理
 */
public class FreeRideTest {

    public static void main(String[] args) {
        RideContext context = new RideContext();
        context.freeRide("咸阳的妇女");
        context.freeRide("西安的老人");
        context.freeRide("渭南的儿童");
    }
}


/**
 * 抽象免费乘车表达式
 * <expression>::=<city>的<person>
 * <city>::= 西安|咸阳
 * <person>::= 老人|妇女|儿童
 */
interface AbstractRideExpression {

    public boolean interpret(String info);

}

/**
 * 终结符表达式解析
 */
class TerminalRideExpression implements AbstractRideExpression {

    private Set<String> terminalExpressions = new HashSet<>();

    public TerminalRideExpression(String[] data) {
        if(data != null && data.length > 0) {
            Collections.addAll(terminalExpressions, data);
        }
    }

    @Override
    public boolean interpret(String info) {
        return terminalExpressions.contains(info);
    }
}

/**
 * 非终结符表达式
 */
class NoTerminalRideExpression implements AbstractRideExpression {

    private AbstractRideExpression city = null;
    private AbstractRideExpression person = null;

    public NoTerminalRideExpression(AbstractRideExpression cityExp, AbstractRideExpression personExp) {
       this.city = cityExp;
       this.person = personExp;
    }

    @Override
    public boolean interpret(String info) {
        String[] datas = info.split("的");
        return city.interpret(datas[0]) && person.interpret(datas[1]);
    }
}

/**
 * 环境类
 */
class RideContext {

    private String[] city = {"西安", "咸阳"};
    private String[] person = {"老人","妇女","儿童"};
    private AbstractRideExpression cityPerson;

    public RideContext() {
        AbstractRideExpression cityExp = new TerminalRideExpression(city);
        AbstractRideExpression personExp = new TerminalRideExpression(person);
        cityPerson = new NoTerminalRideExpression(cityExp, personExp);
    }

    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if(ok) {
            System.out.println("您是" + info + "，可免费乘车。");
        } else {
            System.out.println("您是" + info + "，不属于免费人员，请投币。");
        }
    }

}

