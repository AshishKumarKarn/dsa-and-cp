package karn.platforms.leetcode.contests.weekly490;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Problem2Test {

    @Test
    void isDigitorialPermutation() {
        Problem2 problem2 = new Problem2();
        assertTrue(problem2.isDigitorialPermutation(145));
        assertFalse(problem2.isDigitorialPermutation(10));
    }
}