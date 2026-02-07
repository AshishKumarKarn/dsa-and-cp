package karn.platforms.leetcode.potd.date07022026;

public class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        int bCount = 0;
        int[][] preAPostBCounts = new int[s.length()][2];
        for (int i = 0, j = s.length() - 1; i < s.length(); i++) {
            preAPostBCounts[i][0] = bCount;
            preAPostBCounts[j][1] = aCount;
            if (s.charAt(i) == 'b') {
                bCount++;
            }
            if (s.charAt(j) == 'a') {
                aCount++;
            }
            j--;
        }

        int result = (int) 1e9;
        for (int i = 0; i < s.length(); i++) {
            result = Math.min(result, preAPostBCounts[i][0] + preAPostBCounts[i][1]);
        }
        return result;

    }
}