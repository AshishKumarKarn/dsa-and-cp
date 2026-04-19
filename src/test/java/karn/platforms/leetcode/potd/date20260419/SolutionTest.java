package karn.platforms.leetcode.potd.date20260419;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void maxDistance() {
        Solution solution = new Solution();
        assertEquals(2, solution.maxDistance(new int[]{30, 29, 19, 5},
                new int[]{25, 25, 25, 25, 25}));
    }
}