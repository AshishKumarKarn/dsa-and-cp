package karn.platforms.leetcode.potd.date20260419;
//https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/?envType=daily-question&envId=2026-04-19
//lc 1855. Maximum Distance Between a Pair of Values
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result = Math.max(result, j - i);
                j++;
            } else {
                i++;
            }
        }
        return result;
    }
}