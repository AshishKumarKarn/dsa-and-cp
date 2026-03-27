package karn.platforms.leetcode.potd.date20260328;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void areSimilar() {
        int[][] arr = {{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}};
        assertTrue(new Solution().areSimilar(arr, 2));
    }
}