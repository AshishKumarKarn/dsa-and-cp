package karn.platforms.leetcode.potd.date20260423;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sum-of-distances/?envType=daily-question&envId=2026-04-23
//lc 2615. Sum of Distances
public class Solution {
    public long[] distance(int[] nums) {
        long[] result = new long[nums.length];
        Map<Integer, List<Long>> occs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Long> occ = occs.getOrDefault(nums[i], new ArrayList<>());
            occ.add((long) i);
            occs.put(nums[i], occ);
        }
        for (Map.Entry<Integer, List<Long>> entry : occs.entrySet()) {
            List<Long> occ = entry.getValue();
            if (occ.size() == 1) {
                continue;
            }
            int n = occ.size();
            long[] preSum = new long[n];
            preSum[0] = occ.getFirst();
            for (int i = 1; i < n; i++) {
                preSum[i] = occ.get(i) + preSum[i - 1];
            }

            long[] postSum = new long[n];
            postSum[n - 1] = occ.getLast();
            for (int i = n - 2; i >= 0; i--) {
                postSum[i] = occ.get(i) + postSum[i + 1];
            }
            for (int i = 0; i < n; i++) {
                long ind = occ.get(i);
                long left = i + 1;
                long right = n - i;
                long leftValue = (ind * left) - (preSum[i]);
                long rightValue = postSum[i] - (ind * right);
                result[(int) ind] = (leftValue + rightValue);
            }
        }
        return result;
    }
}