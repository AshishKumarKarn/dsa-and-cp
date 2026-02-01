package karn.platforms.leetcode.contests.biweekly175;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void minimumK() {
        Problem2 problem2 = new Problem2();
        assertEquals(3, problem2.minimumK(new int[]{3, 7, 5}));
        assertEquals(1, problem2.minimumK(new int[]{1}));
        assertEquals(2, problem2.minimumK(new int[]{1, 1}));
        assertEquals(3, problem2.minimumK(new int[]{1, 3, 3}));
    }
}