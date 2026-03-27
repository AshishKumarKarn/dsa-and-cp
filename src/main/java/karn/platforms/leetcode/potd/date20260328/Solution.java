package karn.platforms.leetcode.potd.date20260328;

//https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/?envType=daily-question&envId=2026-03-27
//lc 2946. Matrix Similarity After Cyclic Shifts
public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int col = mat[0].length;
        if (k >= col && (k % col == 0)) {
            return true;
        }
        int[][] copy = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                copy[i][j] = mat[i][j];
            }
        }

        rotate(copy, k);
        return (equal(copy, mat));
    }

    private boolean equal(int[][] src, int[][] tar) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                if (src[i][j] != tar[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void rotate(int[][] copy, int k) {
        for (int i = 0; i < copy.length; i++) {
            if (i % 2 == 0)
                rotate(copy[i], -k);
            else
                rotate(copy[i], k);
        }
    }

    private void rotate(int[] row, int k) {
        int[] temp = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            int ni = i + k;
            if (ni < 0) {
                ni = (50 * row.length + ni) % row.length;
            } else {
                ni = ni % row.length;
            }
            temp[ni] = row[i];
        }
        for (int i = 0; i < row.length; i++) {
            row[i] = temp[i];
        }

    }
}