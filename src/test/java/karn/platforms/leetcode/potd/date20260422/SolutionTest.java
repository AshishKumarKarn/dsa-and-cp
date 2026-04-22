package karn.platforms.leetcode.potd.date20260422;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void twoEditWords() {
        Solution solution = new Solution();
        assertEquals(List.of("iarapqqk", "larakqqk", "nliynmpm", "isikkcws", "laraeqqk"),
                solution.twoEditWords(new String[]{"prfturjd", "iarapqqk", "aokbrtmx", "yafmjorj", "larakqqk", "nliynmpm", "isikkcws", "laraeqqk"}, new String[]{"apahhijt", "larapqqk", "isukkcws", "siqqoacj", "nloynmpm"}));

    }
}