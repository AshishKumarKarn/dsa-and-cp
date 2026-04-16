package karn.platforms.leetcode.potd.date20260416;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void solveQueries() {
        Solution solution = new Solution();
        int[] arr = {13, 13, 10, 6, 5, 2, 6, 6, 1, 1, 18, 18, 6};
        int[] queries = {10, 6, 1, 5, 7};
        assertEquals(List.of(1, 1, 1, -1, 1), solution.solveQueries(arr, queries));
    }
}