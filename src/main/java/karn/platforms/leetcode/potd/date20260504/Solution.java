package karn.platforms.leetcode.potd.date20260504;

//https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2026-05-03
//lc 48. Rotate Image
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        for (int r = i; r < n / 2; r++) {
            for (int c = i; c < n - i - 1; c++) {
                int tl = matrix[r][c];
                int tr = matrix[n - 1 - c][r];
                int br = matrix[n - 1 - r][n - 1 - c];
                int bl = matrix[c][n - 1 - r];

                matrix[r][c] = tr;
                matrix[c][n - 1 - r] = tl;
                matrix[n - 1 - c][r] = br;
                matrix[n - 1 - r][n - 1 - c] = bl;
            }
            i++;
        }
    }
}