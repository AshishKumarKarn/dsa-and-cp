package karn.platforms.leetcode.potd.date20260428;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minOperations() {
        Solution solution = new Solution();
        assertEquals(122, solution.minOperations(new int[][]{
                {454, 328, 160, 286, 664},
                {496, 538, 748, 244, 286},
                {34, 244, 454, 706, 790},
                {496, 538, 832, 958, 328},
                {370, 874, 370, 874, 286}
        }, 42));
    }
}