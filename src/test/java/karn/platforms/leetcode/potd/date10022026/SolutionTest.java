package karn.platforms.leetcode.potd.date10022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestBalanced() {
        Solution solution = new Solution();
        assertEquals(5, solution.longestBalanced(new int[]{3, 2, 2, 5, 4}));
    }
}