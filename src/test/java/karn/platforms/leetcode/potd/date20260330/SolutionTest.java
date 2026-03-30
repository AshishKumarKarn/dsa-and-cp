package karn.platforms.leetcode.potd.date20260330;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void checkStrings() {
        Solution solution = new Solution();
        assertTrue(solution.checkStrings("abcdba", "cabdab"));
        assertFalse(solution.checkStrings("abc", "bca"));
    }
}