package karn.platforms.leetcode.potd.date20260214;

//https://leetcode.com/problems/champagne-tower/description/?envType=daily-question&envId=2026-02-14
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[0][0] = poured;
        for (int i = 0; i < query_row + 1; i++) {
            boolean nextPoured = false;
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1.0) {
                    nextPoured = true;
                    double excess = dp[i][j] - 1.0;
                    dp[i][j] = 1.0;
                    double spilled = excess / 2.0;
                    dp[i + 1][j] += spilled;
                    dp[i + 1][j + 1] += spilled;
                }
            }
            if (!nextPoured) {
                break;
            }
        }
        return dp[query_row][query_glass];
    }
}