package karn.platforms.leetcode.potd.date20260405;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void judgeCircle() {
        Solution solution = new Solution();
        assertTrue(solution.judgeCircle("UD"));
        assertFalse(solution.judgeCircle("LL"));
    }
}