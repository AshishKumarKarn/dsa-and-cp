package karn.platforms.leetcode.contests.weekly490;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem4Test {

    @Test
    void countSequences() {
        Problem4 problem4 = new Problem4();
        assertEquals(2, problem4.countSequences(new int[]{2, 3, 2}, 6));
    }
}