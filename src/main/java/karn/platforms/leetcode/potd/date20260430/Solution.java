package karn.platforms.leetcode.potd.date20260430;

//https://leetcode.com/problems/maximum-path-score-in-a-grid/?envType=daily-question&envId=2026-04-30
//lc 3742. Maximum Path Score in a Grid
public class Solution {

    private static final int min = -(int) 1e9;

    public int maxPathScore(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        k = Math.min(k, r * c);
        int[][][] dp = new int[r][c][k + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int l = 0; l < k + 1; l++) {
                    dp[i][j][l] = min;
                }
            }
        }
        int cost = findCost(0, 0, grid, k, dp);

        return cost < 0 ? -1 : cost;
    }

    private int findCost(int i, int j, int[][] grid, int k, int[][][] dp) {

        if (i >= grid.length || j >= grid[i].length || (grid[i][j] > 0 && k == 0)) {
            return min;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j][k] != min) {
            return dp[i][j][k];
        }
        if (grid[i][j] > 0) {
            k--;
        }

        int down = grid[i][j] + findCost(i + 1, j, grid, k, dp);
        int right = grid[i][j] + findCost(i, j + 1, grid, k, dp);

        if (grid[i][j] > 0) {
            k++;
        }
        return dp[i][j][k] = Math.max(right, down);
    }
}