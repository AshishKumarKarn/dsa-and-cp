package karn.platforms.leetcode.potd.date20260220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void makeLargestSpecial() {
            var solution = new Solution();
            assertEquals("11100100", solution.makeLargestSpecial("11011000"));
    }
}