package karn.platforms.leetcode.potd.date20260201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minimumCost() {
        Solution solution = new Solution();
        assertEquals(6, solution.minimumCost(new int[]{1, 2, 3, 12}));
        assertEquals(12, solution.minimumCost(new int[]{5, 4, 3}));
    }
}