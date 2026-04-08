package karn.platforms.leetcode.potd.date20260408;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void xorAfterQueries() {
        //queries = [[0,0,1,13],[0,0,1,17],[0,0,1,9],[0,0,1,18],[0,0,1,16],[0,0,1,6],[0,0,1,4],[0,0,1,11],[0,0,1,7],[0,0,1,18],[0,0,1,8],[0,0,1,15],[0,0,1,12]]
        // nums =[780]
        //expect = 523618060
        Solution solution = new Solution();
        assertEquals(523618060, solution.xorAfterQueries(new int[]{780}, new int[][]{{0, 0, 1, 13}, {0, 0, 1, 17}, {0, 0, 1, 9}, {0, 0, 1, 18}, {0, 0, 1, 16}, {0, 0, 1, 6}, {0, 0, 1, 4}, {0, 0, 1, 11}, {0, 0, 1, 7}, {0, 0, 1, 18}, {0, 0, 1, 8}, {0, 0, 1, 15}, {0, 0, 1, 12}}));
    }
}