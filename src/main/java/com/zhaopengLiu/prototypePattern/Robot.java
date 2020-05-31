package com.zhaopengLiu.prototypePattern;

/**
 * data: 2020年05月07日
 * author: zhaopengLiu
 * description: 机器人类，原型拓展
 */
public interface Robot {

    Robot clone();

    void doSkill();
}

class CleanRobot implements Robot{

    @Override
    public Robot clone() {
        CleanRobot cleanRobot = null;
        try {
            cleanRobot = (CleanRobot) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cleanRobot;
    }

    @Override
    public void doSkill() {
        System.out.println("我来扫地了");
    }
}

class FightRobot implements Robot {

    @Override
    public Robot clone() {
        FightRobot fightRobot = null;
        try {
            fightRobot = (FightRobot) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return fightRobot;
    }

    @Override
    public void doSkill() {
        System.out.println("我来打架了");
    }
}