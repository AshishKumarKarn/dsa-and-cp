package karn.platforms.leetcode.potd.date20260407;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {
    @Test
    void validateRobotMoves() {
//Given:  ["Robot","step","step","getPos","getDir","step","step","step","getPos","getDir"]
//        [[6,3],[2],[2],[],[],[2],[1],[4],[],[]]

//expect: [null,null,null,[4,0],"East",null,null,null,[1,2],"West"]

        Robot robot = new Robot(6, 3);
        robot.step(2);
        robot.step(2);
        assertArrayEquals(new int[]{4, 0}, robot.getPos());
        assertEquals("East", robot.getDir());
        robot.step(2);
        robot.step(1);
        robot.step(4);
        assertArrayEquals(new int[]{1, 2}, robot.getPos());
        assertEquals("West", robot.getDir());


    }

}