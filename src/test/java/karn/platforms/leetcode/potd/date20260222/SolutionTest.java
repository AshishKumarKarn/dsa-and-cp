package karn.platforms.leetcode.potd.date20260222;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void binaryGap() {
        Solution solution = new Solution();
        assertEquals(2, solution.binaryGap(5));
        assertEquals(0, solution.binaryGap(8));
    }
}