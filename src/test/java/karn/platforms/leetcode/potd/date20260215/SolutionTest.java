package karn.platforms.leetcode.potd.date20260215;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void addBinary() {
        Solution solution = new Solution();
        assertEquals("10101", solution.addBinary("1010", "1011"));
    }
}