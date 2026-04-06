package karn.platforms.leetcode.potd.date20260406;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void robotSim() {
        Solution solution = new Solution();
        assertEquals(25, solution.robotSim(new int[]{4, -1, 3}, new int[][]{}));
        assertEquals(65, solution.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }
}