package karn.platforms.leetcode.potd.date20260417;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/?envType=daily-question&envId=2026-04-17
//lc 3761. Minimum Absolute Distance Between Mirror Pairs
public class Solution {
    private static final int MAX = (int) 1e9;

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> reverseOccs = new HashMap<>();
        int result = MAX;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int reverse = reverse(nums[i]);
            if (reverseOccs.containsKey(reverse)) {
                result = Math.min(result, reverseOccs.get(reverse) - i);
            }
            reverseOccs.put(num, i);
        }
        return result == MAX ? -1 : result;
    }

    //reverse(nums[i])==nums[j]
    //reverse of 120 = 21 but reverse of 21 is 12 not 120
    private int reverse(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}