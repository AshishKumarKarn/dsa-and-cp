package karn.platforms.leetcode.contests.biweekly175;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void longestSubsequence() {
        Problem3 problem3 = new Problem3();
        assertEquals(2, problem3.longestSubsequence(new int[]{5, 4, 7}));
        assertEquals(3, problem3.longestSubsequence(new int[]{2, 3, 6}));
    }
}