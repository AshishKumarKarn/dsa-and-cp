package karn.platforms.leetcode.medium.lc3835;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long result = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int right = 0; right < nums.length; right++) {
            minHeap.add(nums[right]);
            maxHeap.add(nums[right]);

            // Shrink window until it's valid
            while (!minHeap.isEmpty() && !maxHeap.isEmpty() &&
                    (long)(maxHeap.peek() - minHeap.peek()) * (right - left + 1) > k) {

                minHeap.remove(nums[left]);
                maxHeap.remove(nums[left]);
                left++;
            }

            // Now window [left..right] is valid
            result += (right - left + 1);
        }

        return result;
    }

}