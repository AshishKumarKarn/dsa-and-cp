package karn.platforms.leetcode.potd.date20260329;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void findTheString() {
        Solution solution = new Solution();
        int[][] lcp = {{4, 0, 2, 0}, {0, 3, 0, 1}, {2, 0, 2, 0}, {0, 1, 0, 1}};
        assertEquals("abab", solution.findTheString(lcp));
    }
}