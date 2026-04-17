package karn.platforms.leetcode.potd.date20260417;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minMirrorPairDistance() {
        Solution solution = new Solution();
        assertEquals(1, solution.minMirrorPairDistance(new int[]{12, 21, 45, 33, 54}));
        assertEquals(1, solution.minMirrorPairDistance(new int[]{120, 21}));
        assertEquals(-1, solution.minMirrorPairDistance(new int[]{21, 120}));
    }
}