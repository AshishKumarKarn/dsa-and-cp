package karn.platforms.leetcode.potd.date20260501;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxRotateFunction() {
        assertEquals(26, new Solution().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}