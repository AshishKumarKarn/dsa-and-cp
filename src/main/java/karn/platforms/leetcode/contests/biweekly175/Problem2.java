package karn.platforms.leetcode.contests.biweekly175;

//https://leetcode.com/problems/minimum-k-to-reduce-array-within-limit/description/
public class Problem2 {
    public int minimumK(int[] nums) {
        long left = 1;
        long right = (int) 1e9;
        long result = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (nonPositive(nums, mid)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) result;
    }

    private boolean nonPositive(int[] nums, long k) {
        long res = 0;
        for (int num : nums) {
            res = res + ((num - 1) / k) + 1;

        }
        return res <= (k * k);
    }
}
