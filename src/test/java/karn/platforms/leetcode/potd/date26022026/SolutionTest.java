package karn.platforms.leetcode.potd.date26022026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void numSteps() {
        Solution solution = new Solution();
        assertEquals(6, solution.numSteps("1101"));
    }
}