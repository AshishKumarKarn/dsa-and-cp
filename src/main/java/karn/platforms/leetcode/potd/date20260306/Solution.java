package karn.platforms.leetcode.potd.date20260306;

//https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/?envType=daily-question&envId=2026-03-06
//lc 1784
public class Solution {
    public boolean checkOnesSegment(String s) {
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }
}