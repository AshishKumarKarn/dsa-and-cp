package karn.platforms.leetcode.potd.date05022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void constructTransformedArray() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{2, -100, -40, -40, -1, -1, -40}, solution.constructTransformedArray(new int[]{-1, -40, -1, -100, 3, 4, 2}));
    }
}