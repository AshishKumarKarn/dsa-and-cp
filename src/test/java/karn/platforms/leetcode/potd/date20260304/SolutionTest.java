package karn.platforms.leetcode.potd.date20260304;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void numSpecial() {
        var solution = new Solution();
        int[][] mat = new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        assertEquals(1, solution.numSpecial(mat));
    }
}