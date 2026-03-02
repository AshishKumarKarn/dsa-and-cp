package karn.platforms.leetcode.potd.date20260302;

//https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/?envType=daily-question&envId=2026-03-02
//lc 1536
public class Solution {

    public int minSwaps(int[][] grid) {
        int n = grid.length;

        // Count trailing zeros for each row
        int[] rows = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) break;
                count++;
            }
            rows[i] = count;
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {

            int required = n - 1 - i;

            int j = i;

            // Find row that satisfies condition
            while (j < n && rows[j] < required) {
                j++;
            }

            // No valid row found
            if (j == n) return -1;

            // Bubble row j to position i
            while (j > i) {
                int temp = rows[j];
                rows[j] = rows[j - 1];
                rows[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}