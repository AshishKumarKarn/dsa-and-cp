package karn.platforms.leetcode.contests.weekly490;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem3Test {

    @Test
    void maximumXor() {
        Problem3 problem3 = new Problem3();
        assertEquals("110", problem3.maximumXor("101", "011"));
        assertEquals("1111", problem3.maximumXor("0101", "1001"));
    }
}