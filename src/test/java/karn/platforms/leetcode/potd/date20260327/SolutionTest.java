package karn.platforms.leetcode.potd.date20260327;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void canPartitionGrid() {
        int[][] grid1 = {{1, 2}, {3, 4}};
        assertTrue(new Solution().canPartitionGrid(grid1));

        int[][] grid2 = {{1, 1}, {1, 1}};
        assertTrue(new Solution().canPartitionGrid(grid2));

        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertFalse(new Solution().canPartitionGrid(grid3));

        int[][] grid4 = {{4, 1, 8}, {3, 2, 6}};
        assertFalse(new Solution().canPartitionGrid(grid4));

    }
}