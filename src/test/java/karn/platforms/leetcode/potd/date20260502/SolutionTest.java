package karn.platforms.leetcode.potd.date20260502;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void rotatedDigits() {
        assertEquals(4, new Solution().rotatedDigits(10));
        assertEquals(976, new Solution().rotatedDigits(5000));
    }
}