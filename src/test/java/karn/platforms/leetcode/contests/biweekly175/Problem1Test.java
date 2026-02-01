package karn.platforms.leetcode.contests.biweekly175;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void reverseByType() {
        Problem1 problem1 = new Problem1();
        assertEquals(")(*&^%$#@!", problem1.reverseByType("!@#$%^&*()"));
        assertEquals("(fad@cb#e)", problem1.reverseByType(")ebc#da@f("));
    }
}