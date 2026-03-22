package karn.platforms.leetcode.potd.date20260322;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void findRotation() {
        Solution solution = new Solution();

        int[][] mat1 = {{0, 1}, {1, 0}};
        int[][] target1 = {{1, 0}, {0, 1}};
        assertTrue(solution.findRotation(mat1, target1));

        int[][] mat2 = {{0, 1}, {1, 1}};
        int[][] target2 = {{1, 0}, {0, 1}};
        assertFalse(solution.findRotation(mat2, target2));

        int[][] mat3 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target3 = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        assertTrue(solution.findRotation(mat3, target3));
    }
}