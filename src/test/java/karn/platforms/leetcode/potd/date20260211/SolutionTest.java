package karn.platforms.leetcode.potd.date20260211;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void longestBalanced() {
        Solution solution = new Solution();
        assertEquals(3, solution.longestBalanced(new int[]{1, 2, 3, 2}));
    }
}