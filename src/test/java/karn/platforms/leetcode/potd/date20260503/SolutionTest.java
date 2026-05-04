package karn.platforms.leetcode.potd.date20260503;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void rotateString() {
        assertTrue(new Solution().rotateString("abcde", "cdeab"));
        assertFalse(new Solution().rotateString("abcde", "abced"));
    }
}