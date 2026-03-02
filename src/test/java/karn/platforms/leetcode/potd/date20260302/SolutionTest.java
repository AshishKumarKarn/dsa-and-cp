package karn.platforms.leetcode.potd.date20260302;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minSwaps() {
        int[][] binaryGrid = new int[][]{
                {0, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };
        Solution solution = new Solution();
        assertEquals(3, solution.minSwaps(binaryGrid));
    }
}