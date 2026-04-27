package karn.platforms.leetcode.potd.date20260427;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void hasValidPath() {
        assertTrue(new Solution().hasValidPath(new int[][]{
                {4, 1},
                {6, 1}
        }));
        assertTrue(new Solution().hasValidPath(new int[][]{
                {2, 4, 3},
                {6, 5, 2}
        }));
        assertFalse(new Solution().hasValidPath(new int[][]{
                {1, 2, 1},
                {1, 2, 1}
        }));
    }
}