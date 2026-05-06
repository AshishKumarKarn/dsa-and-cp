package karn.platforms.leetcode.potd.date20260506;

import java.util.Arrays;
//https://leetcode.com/problems/rotating-the-box/?envType=daily-question&envId=2026-05-06
//lc 1861. Rotating the Box
public class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] result = new char[n][m];
        for (char[] res : result) {
            Arrays.fill(res, '.');
        }

        for (int i = 0; i < m; i++) {
            int obs = n;
            int stone = 0;
            for (int j = 0; j < n; j++) {
                if (boxGrid[i][j] == '*') {
                    obs = j;
                    result[j][m-1-i] = '*';
                } else if (boxGrid[i][j] == '#') {
                    stone++;
                }
                if (obs == j) {
                    int k = j - 1;
                    while (stone > 0) {
                        result[k--][m-1-i] = '#';
                        stone--;
                    }
                }
            }
            int k = n - 1;
            while (stone > 0) {
                result[k--][m-1-i] = '#';
                stone--;
            }
        }
        return result;
    }
}