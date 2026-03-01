package karn.platforms.leetcode.potd.date20260205;

//https://leetcode.com/problems/transformed-array/?envType=daily-question&envId=2026-02-05
public class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int j = (i + nums[i]) % nums.length;
                result[i] = nums[j];
            } else {
                int j = ((100 * nums.length) + i + nums[i]) % nums.length;
                result[i] = nums[j];
            }
        }
        return result;
    }
}