package karn.platforms.leetcode.potd.date20260413;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void getMinDistance() {
        Solution solution = new Solution();
        assertEquals(1, solution.getMinDistance(new int[]{1, 2, 3, 4}, 2, 2));
        assertEquals(1, solution.getMinDistance(new int[]{1, 3, 5, 7}, 5, 3));
    }
}