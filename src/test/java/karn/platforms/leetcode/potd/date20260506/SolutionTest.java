package karn.platforms.leetcode.potd.date20260506;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rotateTheBox() {
        assertArrayEquals(new char[][]{
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        }, new Solution().rotateTheBox(new char[][]{
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        }));
    }
}