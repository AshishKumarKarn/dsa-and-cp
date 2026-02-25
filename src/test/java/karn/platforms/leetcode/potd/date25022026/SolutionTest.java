package karn.platforms.leetcode.potd.date25022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class SolutionTest {

    @Test
    void sortByBits() {
        Solution solution = new Solution();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}, solution.sortByBits(arr));
    }
}