package karn.platforms.leetcode.potd.date20260420;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void maxDistance() {
        Solution solution = new Solution();
        assertEquals(10, solution.maxDistance(new int[]{
                1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 2
        }));
        assertEquals(5, solution.maxDistance(new int[]{
                1, 1, 1, 1, 1, 6, 1, 1, 1
        }));
        assertEquals(6, solution.maxDistance(new int[]{
                1, 1, 1, 6, 1, 1, 1, 1, 1, 1
        }));
        assertEquals(1, solution.maxDistance(new int[]{
                0, 1
        }));
    }
}