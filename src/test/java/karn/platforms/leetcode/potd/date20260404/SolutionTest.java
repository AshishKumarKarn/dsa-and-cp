package karn.platforms.leetcode.potd.date20260404;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void decodeCiphertext() {
        Solution solution = new Solution();
        assertEquals("i love leetcode", solution.decodeCiphertext("iveo    eed   l te   olc", 4));
        assertEquals(" abc", solution.decodeCiphertext(" b  ac", 2));
    }
}