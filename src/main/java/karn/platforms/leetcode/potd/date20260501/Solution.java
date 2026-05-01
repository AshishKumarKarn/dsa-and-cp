package karn.platforms.leetcode.potd.date20260501;
//https://leetcode.com/problems/rotate-function/?envType=daily-question&envId=2026-05-01
//lc 396. Rotate Function
public class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 1) return 0;
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }
        int ind = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] * ind);
            ind++;
        }
        int max = sum;
        for (int i = nums.length - 1; i >= 0; i--) {
            int lv = nums[i];
            int currentSum = sum + totalSum - (nums.length * lv);
            max = Math.max(max, currentSum);
            sum = currentSum;
        }
        return max;

    }
}