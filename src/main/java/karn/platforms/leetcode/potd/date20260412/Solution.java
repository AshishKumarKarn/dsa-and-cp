package karn.platforms.leetcode.potd.date20260412;


//https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/description/
//lc 1320. Minimum Distance to Type a Word Using Two Fingers
public class Solution {

    private final int[][] locations = new int[][] {
            {0,0},{0,1},{0,2},{0,3},{0,4},{0,5},
            {1,0},{1,1},{1,2},{1,3},{1,4},{1,5},
            {2,0},{2,1},{2,2},{2,3},{2,4},{2,5},
            {3,0},{3,1},{3,2},{3,3},{3,4},{3,5},
            {4,0},{4,1},{4,2},{4,3},{4,4},{4,5}
    };

    private Integer[][][] memo;

    public int minimumDistance(String word) {
        int n = word.length();

        // 27 because we use 26 for "free finger"
        memo = new Integer[n][27][27];
        return dfs(0, 26, 26, word);
    }

    private int dfs(int index, int f1, int f2, String word) {

        if (index == word.length()) return 0;

        if (memo[index][f1][f2] != null) {
            return memo[index][f1][f2];
        }

        int curr = word.charAt(index) - 'A';

        // Option 1: use finger1
        int cost1 = dist(f1, curr) + dfs(index + 1, curr, f2, word);

        // Option 2: use finger2
        int cost2 = dist(f2, curr) + dfs(index + 1, f1, curr, word);

        return memo[index][f1][f2] = Math.min(cost1, cost2);
    }

    private int dist(int a, int b) {
        if (a == 26) return 0; // free finger

        int[] p1 = locations[a];
        int[] p2 = locations[b];

        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}