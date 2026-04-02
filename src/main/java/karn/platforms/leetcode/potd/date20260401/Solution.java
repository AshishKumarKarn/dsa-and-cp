package karn.platforms.leetcode.potd.date20260401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/robot-collisions/?envType=daily-question&envId=2026-04-01
// lc 2751. Robot Collisions
public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Robot[] robots = new Robot[positions.length];
        for (int i = 0; i < positions.length; i++) {
            Robot robot = new Robot(positions[i], healths[i], directions.charAt(i));
            robots[i] = robot;
        }
        Arrays.sort(robots, (r1, r2) -> r1.position - r2.position);
        List<Robot> result = new ArrayList<>();
        Stack<Robot> stack = new Stack<>();
        for (int i = 0; i < robots.length; i++) {
            Robot robot = robots[i];
            if (robot.direction == 'L' && stack.isEmpty()) {
                result.add(robot);
            } else if (robot.direction == 'L') {
                boolean currentRobotCanBeSaved = false;
                while (!stack.isEmpty()) {
                    Robot last = stack.pop();
                    if (last.health > robot.health) {
                        last.health = last.health - 1;
                        stack.push(last);
                        currentRobotCanBeSaved = false;
                        break;
                    } else if (last.health < robot.health) {
                        robot.health = robot.health - 1;
                        currentRobotCanBeSaved = true;
                    } else {
                        currentRobotCanBeSaved = false;
                        break;
                    }
                }
                if (currentRobotCanBeSaved) {
                    result.add(robot);
                }
            } else if (robot.direction == 'R') {
                stack.push(robot);
            }
            //no other condition possible
        }
        result.addAll(stack);
        Map<Integer, Robot> map = new HashMap<>();
        for (Robot robot : result) {
            map.put(robot.position, robot);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            if (map.containsKey(positions[i])) {
                res.add(map.get(positions[i]).health);
            }
        }
        return res;

    }

    class Robot {
        int position;
        int health;
        char direction;

        Robot(int position, int health, char direction) {
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
}
