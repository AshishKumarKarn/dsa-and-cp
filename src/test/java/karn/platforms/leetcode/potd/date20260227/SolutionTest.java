package karn.platforms.leetcode.potd.date20260227;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minOperations() {
        Solution solution = new Solution();
        assertEquals(2, solution.minOperations("0101", 3));
    }
}