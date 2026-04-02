package karn.platforms.leetcode.potd.date20260402;
//https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/description/?envType=daily-question&envId=2026-04-02
// lc 3418. Maximum Amount of Money Robot Can Earn
public class Solution {
    private static final int MIN = (int) -1e9;

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for (int[][] d : dp) {
            for (int i = 0; i < n; i++) {
                d[i][0] = MIN;
                d[i][1] = MIN;
                d[i][2] = MIN;
            }
        }
        return dfs(coins, m, n, 0, 0, 2, dp);
    }

    private int dfs(int[][] coins, int m, int n, int i, int j, int neut, int[][][] dp) {
        if (i >= m || j >= n) {
            return MIN;
        }
        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && neut > 0) {
                return 0;
            }
            return coins[i][j];
        }
        if (dp[i][j][neut] != MIN) {
            return dp[i][j][neut];
        }
        if (coins[i][j] < 0 && neut > 0) {
            int useN = Math.max(dfs(coins, m, n, i + 1, j, neut - 1, dp),
                    dfs(coins, m, n, i, j + 1, neut - 1, dp));
            int doNotUseN = coins[i][j] + Math.max(dfs(coins, m, n, i + 1, j,
                    neut, dp), dfs(coins, m, n, i, j + 1, neut, dp));
            return dp[i][j][neut] = Math.max(useN, doNotUseN);
        } else {
            return dp[i][j][neut] = coins[i][j] + Math.max(dfs(coins, m, n, i + 1, j, neut, dp),
                    dfs(coins, m, n, i, j + 1, neut, dp));
        }

    }
}