package karn.interviews.guidewire.round3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        assertArrayEquals(new String[]{"1-6", "9-11"}, solution.solution(new String[]{"9-11", "1-2", "3-5", "4-6"}));
    }
}