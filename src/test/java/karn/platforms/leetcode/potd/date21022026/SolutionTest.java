package karn.platforms.leetcode.potd.date21022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void countPrimeSetBits() {
        Solution solution = new Solution();
        assertEquals(1465, solution.countPrimeSetBits(289051, 294301));
        assertEquals(2036, solution.countPrimeSetBits(977581, 983119));
    }
}