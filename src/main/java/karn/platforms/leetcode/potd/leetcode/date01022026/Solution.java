package karn.platforms.leetcode.potd.leetcode.date01022026;

//https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/?envType=daily-question&envId=2026-02-01
// leetcode3010
public class Solution {
    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int minI = -1;
        for (int i = 1; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min1 = nums[i];
                minI = i;
            }
        }
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (i == minI) {
                continue;
            }
            min2 = Math.min(nums[i], min2);
        }
        return nums[0] + min1 + min2;

    }
}
