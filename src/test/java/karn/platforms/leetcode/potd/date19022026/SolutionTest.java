package karn.platforms.leetcode.potd.date19022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void countBinarySubstrings() {
        Solution solution = new Solution();
        assertEquals(6, solution.countBinarySubstrings("00110011"));
        assertEquals(4, solution.countBinarySubstrings("10101"));
    }
}