package karn.platforms.leetcode.potd.date20260428;

import java.util.Arrays;
//https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/?envType=daily-question&envId=2026-04-28
//lc 2033. Minimum Operations to Make a Uni-Value Grid
public class Solution {
    public int minOperations(int[][] grid, int x) {
        int ind = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[ind++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int result = 0;
        int target = arr[m * n / 2];
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(target - arr[i]);
            if (diff % x != 0) {
                return -1;
            }
            result += (diff / x);
        }
        return result;
    }
}