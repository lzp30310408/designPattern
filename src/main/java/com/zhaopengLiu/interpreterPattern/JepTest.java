package com.zhaopengLiu.interpreterPattern;


import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 * data: 2020年05月31日
 * author: zhaopengLiu
 * description:jepDemo
 */
public class JepTest {

    public static void main(String[] args) {
        try {
            JEP jep = new JEP();
            String interest = "本金*利率*年份";
            jep.addVariable("本金", 10000.0);
            jep.addVariable("利率", 0.038);
            jep.addVariable("年份", 3);
            Node parse = jep.parse(interest);
            System.out.println("存款利息：" + jep.evaluate(parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
