package karn.platforms.leetcode.potd.date20260418;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void mirrorDistance() {
        Solution solution = new Solution();
        assertEquals(0, solution.mirrorDistance(7));
        assertEquals(27, solution.mirrorDistance(25));
        assertEquals(9, solution.mirrorDistance(10));
    }
}