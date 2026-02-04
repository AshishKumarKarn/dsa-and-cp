package karn.platforms.leetcode.potd.date03022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void isTrionic() {
        Solution solution = new Solution();
        assertTrue(solution.isTrionic(new int[]{1, 3, 5, 4, 2, 6}));
        assertFalse(solution.isTrionic(new int[]{2, 1, 3}));
        assertFalse(solution.isTrionic(new int[]{3, 3, 8, 1, 4, 6}));
    }
}