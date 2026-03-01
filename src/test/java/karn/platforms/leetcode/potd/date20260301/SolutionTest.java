package karn.platforms.leetcode.potd.date20260301;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minPartitions() {
        Solution solution = new Solution();
        assertEquals(9, solution.minPartitions("27346209830709182346"));
    }
}