package karn.platforms.leetcode.potd.date20260306;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void checkOnesSegment() {
        Solution solution = new Solution();
        assertTrue(solution.checkOnesSegment("100"));
        assertTrue(solution.checkOnesSegment("11100"));
        assertFalse(solution.checkOnesSegment("111001"));
    }
}