package karn.platforms.leetcode.potd.date20260430;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxPathScore() {
        assertEquals(7, new Solution().maxPathScore(new int[][]{
                {0, 1, 1, 1},
                {1, 2, 2, 0},
                {1, 0, 1, 2}
        }, 4));
    }
}