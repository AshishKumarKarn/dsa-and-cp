package karn.platforms.leetcode.contests.weekly490;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem1Test {

    @Test
    void scoreDifference() {
        Problem1 problem1 = new Problem1();
        assertEquals(0, problem1.scoreDifference(new int[]{1,2,3}));
        assertEquals(4, problem1.scoreDifference(new int[]{2,4,2,1,2,1}));
    }
}