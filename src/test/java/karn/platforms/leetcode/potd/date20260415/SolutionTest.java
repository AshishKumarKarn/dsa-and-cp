package karn.platforms.leetcode.potd.date20260415;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void closestTarget() {
        Solution solution = new Solution();
        assertEquals(1, solution.closestTarget(new String[]{"a","b","leetcode"}, "leetcode", 0));
        assertEquals(1, solution.closestTarget(new String[]{"hello","i","am","leetcode","hello"}, "hello", 1));
        assertEquals(-1, solution.closestTarget(new String[]{"i","eat","leetcode"}, "ate", 0));
    }
}