package karn.platforms.leetcode.contests.biweekly175;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/longest-strictly-increasing-subsequence-with-non-zero-bitwise-and/
public class Problem3 {
    public int longestSubsequence(int[] nums) {
        int ans = 0;

        for (int bit = 0; bit < 32; bit++) {
            List<Integer> list = new ArrayList<>();

            // filter numbers with this bit set
            for (int x : nums) {
                if ((x & (1 << bit)) != 0) {
                    list.add(x);
                }
            }

            if (list.isEmpty()) continue;

            ans = Math.max(ans, lisLength(list));
        }
        return ans;
    }

    // #v.v.i Standard LIS (patience sorting)
    private int lisLength(List<Integer> arr) {
        List<Integer> tails = new ArrayList<>();

        for (int x : arr) {
            int idx = Collections.binarySearch(tails, x);
            if (idx < 0) idx = -idx - 1;

            if (idx == tails.size()) {
                tails.add(x);
            } else {
                tails.set(idx, x);
            }
        }
        return tails.size();
    }
}
