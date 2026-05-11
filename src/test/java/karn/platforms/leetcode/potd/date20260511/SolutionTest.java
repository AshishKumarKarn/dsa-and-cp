package karn.platforms.leetcode.potd.date20260511;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void separateDigits() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, new Solution().separateDigits(new int[]{123, 4}));
        assertArrayEquals(new int[]{7, 1, 3, 0}, new Solution().separateDigits(new int[]{7, 1, 30}));
    }
}