package karn.platforms.leetcode.potd.date20260401;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void survivedRobotsHealths() {
        Solution solution = new Solution();
        int[] positions1 = {3, 5, 2, 6};
        int[] healths1 = {10, 10, 15, 12};
        String directions1 = "RLRL";
        assertEquals(List.of(14), solution.survivedRobotsHealths(positions1, healths1, directions1));

    }
}