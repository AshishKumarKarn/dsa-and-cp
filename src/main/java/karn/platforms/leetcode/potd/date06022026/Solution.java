package karn.platforms.leetcode.potd.date06022026;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-removals-to-balance-array/description/?envType=daily-question&envId=2026-02-06
public class Solution {
    public int minRemoval(int[] nums, int k) {

        Arrays.sort(nums);

        //we will take two pointer approach
        // consider a left and move the right pointer (using binary search)
        // to the element where nums[right]<=k*nums[left];
        // stop as soon as the right pointer touches the end of the array
        // 1 2 5 k=2
        int result = (int) 1e9;
        for (int i = 0; i < nums.length; i++) {
            long rightMax = k * (long) nums[i];
            int rightInd = binarySearch(nums, i, rightMax);
            result = Math.min(result, i + nums.length - 1 - rightInd);//left + nums.length-right-1 indicates count of numbers to deleted
            if (rightInd == nums.length - 1) {
                break;
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int left, long rightMax) {
        int right = nums.length - 1;
        int result = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= rightMax) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
