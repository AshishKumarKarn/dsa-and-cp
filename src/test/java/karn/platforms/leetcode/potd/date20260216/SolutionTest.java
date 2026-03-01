package karn.platforms.leetcode.potd.date20260216;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void reverseBits() {
        Solution solution = new Solution();
        assertEquals(1073741824, solution.reverseBits(2));
        assertEquals(964176192, solution.reverseBits(43261596));
    }
}