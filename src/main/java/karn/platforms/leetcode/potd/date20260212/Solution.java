package karn.platforms.leetcode.potd.date20260212;

//https://leetcode.com/problems/longest-balanced-substring-i/?envType=daily-question&envId=2026-02-12
public class Solution {
    public int longestBalanced(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] arr = new int[26];
            for (int j = i; j < s.length(); j++) {
                arr[s.charAt(j) - 'a']++;
                if (hasEqual(arr)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean hasEqual(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j == 0) {
                continue;
            }
            if (count == 0) {
                count = j;
            } else {
                if (count != j) {
                    return false;
                }
            }
        }
        return true;
    }
}