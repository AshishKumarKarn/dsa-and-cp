package karn.platforms.leetcode.potd.date20260213;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void longestBalanced() {
        Solution solution = new Solution();
        assertEquals(3, solution.longestBalanced("aabcc"));
    }
}