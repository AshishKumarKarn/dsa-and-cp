package karn.platforms.leetcode.potd.date20260305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minOperations() {
        Solution solution = new Solution();
        assertEquals(1, solution.minOperations("0100"));
    }
}