package karn.platforms.leetcode.potd.date20260423;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void distance() {
        Solution solution = new Solution();
        assertArrayEquals(new long[]{17, 10, 8, 4, 0, 8, 10, 4, 9, 10}, solution.distance(new int[]{2, 1, 1, 3, 5, 1, 1, 3, 2, 2}));
    }
}