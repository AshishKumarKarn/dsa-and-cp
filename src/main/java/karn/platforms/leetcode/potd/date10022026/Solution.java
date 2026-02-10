package karn.platforms.leetcode.potd.date10022026;

//https://leetcode.com/problems/longest-balanced-subarray-i/?envType=daily-question&envId=2026-02-10
public class Solution {

    public int longestBalanced(int[] nums) {
        int max = 0;
        int[] frequencies = new int[100001];
        int ec = 0;
        int oc = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (frequencies[nums[j]] == 0) {
                    if (nums[j] % 2 == 0) {
                        ec++;
                    } else {
                        oc++;
                    }
                }
                frequencies[nums[j]]++;
                if (oc == ec) {
                    max = Math.max(j - i + 1, max);
                }
            }
            for (int j = i; j < nums.length; j++) {
                if (frequencies[nums[j]] == 1) {
                    if (nums[j] % 2 == 0) {
                        ec--;
                    } else {
                        oc--;
                    }
                }
                frequencies[nums[j]]--;
            }

        }
        return max;
    }
    //working but little slower
//    public int longestBalanced(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            Set<Integer> even = new HashSet<>();
//            Set<Integer> odd = new HashSet<>();
//            for (int j = i; j < nums.length; j++) {
//                if (nums[j] % 2 == 0) {
//                    even.add(nums[j]);
//                } else {
//                    odd.add(nums[j]);
//                }
//                if (even.size() == odd.size()) {
//                    max = Math.max(j - i + 1, max);
//                }
//            }
//        }
//        return max;
//    }
}