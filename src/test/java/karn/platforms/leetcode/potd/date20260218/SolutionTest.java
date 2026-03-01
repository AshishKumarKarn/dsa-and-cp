package karn.platforms.leetcode.potd.date20260218;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void hasAlternatingBits() {
        Solution solution = new Solution();
        assertTrue(solution.hasAlternatingBits(5));
        assertTrue(solution.hasAlternatingBits(2));
        assertFalse(solution.hasAlternatingBits(7));
        assertFalse(solution.hasAlternatingBits(11));

    }
}