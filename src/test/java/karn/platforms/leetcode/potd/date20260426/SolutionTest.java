package karn.platforms.leetcode.potd.date20260426;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void containsCycle() {
        assertTrue(new Solution().containsCycle(new char[][]{
                {'a', 'a', 'a', 'a'},
                {'b', 'b', 'b', 'a'},
                {'b', 'c', 'b', 'a'},
                {'b', 'b', 'b', 'a'}
        }));
    }
}