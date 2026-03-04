package karn.platforms.leetcode.potd.date20260304;
//https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/?envType=daily-question&envId=2026-03-04
// lc 1582
public class Solution {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            rows[i] = sum;
        }
        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            cols[i] = sum;
        }
        int specials = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    specials++;
                }
            }
        }
        return specials;
    }
}