package karn.platforms.leetcode.potd.date04022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void maxSumTrionic() {
        Solution solution = new Solution();
        assertEquals(-4, solution.maxSumTrionic(new int[]{0, -2, -1, -3, 0, 2, -1}));
    }
}