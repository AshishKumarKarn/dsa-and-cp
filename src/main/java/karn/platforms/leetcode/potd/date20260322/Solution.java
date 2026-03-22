package karn.platforms.leetcode.potd.date20260322;

//https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/?envType=daily-question&envId=2026-03-22
//lc 1886. Determine Whether Matrix Can Be Obtained By Rotation
public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = 0;
        while (n < 4) {
            rotate90(mat);
            if (arrayEquals(mat, target)) {
                return true;
            }
            n++;
        }
        return false;
    }

    private boolean arrayEquals(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void rotate90(int[][] mat) {
        int n = mat.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - i - 1] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = temp[i][j];
            }
        }
    }
}