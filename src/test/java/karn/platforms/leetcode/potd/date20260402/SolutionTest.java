package karn.platforms.leetcode.potd.date20260402;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void maximumAmount() {
        Solution solution = new Solution();
        int[][] arr = {{-16, 8, -7, -19}, {6, 3, -10, 13}, {13, 15, 4, -3}, {-16, 4, 19, -12}};
        assertEquals(57, solution.maximumAmount(arr));
    }
}