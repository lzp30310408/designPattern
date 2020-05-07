package com.zhaopengLiu.prototypePattern;

import java.util.HashMap;
import java.util.Map;

/**
 * data: 2020年05月07日
 * author: zhaopengLiu
 * description:
 */
public class RobotManager {

    private Map<String, Robot> robotMap = new HashMap<>();

    public RobotManager() {
        robotMap.put("clean", new CleanRobot());
        robotMap.put("fight", new FightRobot());
    }

    public void addRobot(String key, Robot robot) {
        robotMap.put(key, robot);
    }

    public Robot getRobot(String key) {
        return robotMap.get(key);
    }

}

class RobotSkill {
    public static void main(String[] args) {
        RobotManager robotManager = new RobotManager();
        Robot cleanRobot = robotManager.getRobot("clean");
        cleanRobot.doSkill();
        Robot fightRobot = robotManager.getRobot("fight");
        fightRobot.doSkill();
    }
}
