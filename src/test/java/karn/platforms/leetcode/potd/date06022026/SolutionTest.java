package karn.platforms.leetcode.potd.date06022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minRemoval() {
        Solution solution = new Solution();
        assertEquals(3, solution.minRemoval(new int[]{32, 607, 740, 134, 944, 91, 410, 155, 493, 89, 12}, 10));
    }
}