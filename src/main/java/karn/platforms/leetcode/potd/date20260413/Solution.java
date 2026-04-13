package karn.platforms.leetcode.potd.date20260413;
//https://leetcode.com/problems/minimum-distance-to-the-target-element/?envType=daily-question&envId=2026-04-13
//lc 1848. Minimum Distance to the Target Element
public class Solution {

    public int getMinDistance(int[] nums, int target, int start) {
        int result = (int) 1e9;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }
        return result;
    }
}