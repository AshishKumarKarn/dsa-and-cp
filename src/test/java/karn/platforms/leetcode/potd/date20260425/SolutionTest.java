package karn.platforms.leetcode.potd.date20260425;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxDistance() {//2,
        //[[0,0],[1,2],[2,0],[2,2],[2,1]]
        //4
        assertEquals(1, new Solution().maxDistance(2, new int[][]{
                {0, 0},
                {1, 0},
                {1, 2},
                {2, 0},
                {2, 2},
                {2, 1}
        }, 4));
    }
}