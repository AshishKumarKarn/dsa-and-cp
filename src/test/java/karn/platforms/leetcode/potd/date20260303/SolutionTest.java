package karn.platforms.leetcode.potd.date20260303;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void findKthBit() {
        Solution solution = new Solution();
        assertEquals('0', solution.findKthBit(3, 1));
    }
}