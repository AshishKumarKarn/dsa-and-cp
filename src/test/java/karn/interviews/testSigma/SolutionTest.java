package karn.interviews.testSigma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void swap() {
        Solution solution  = new Solution();
        assertEquals(1, solution.swap(new int[]{1, 1, 1, 0, 1, 0, 1, 0, 0, 0}));
        assertEquals(1, solution.swap(new int[]{1, 1, 1, 0, 1, 0, 1, 0, 0, 0}));
    }
}