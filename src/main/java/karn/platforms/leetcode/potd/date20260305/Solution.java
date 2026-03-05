package karn.platforms.leetcode.potd.date20260305;

//https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/?envType=daily-question&envId=2026-03-05
//lc 1758
public class Solution {
    public int minOperations(String s) {
        int z = 0;//assumes alternating string starts with 0;
        int o = 0;//assumes alternating string starts with 1;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    o++;
                } else {
                    z++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    z++;
                } else {
                    o++;
                }
            }
        }
        return Math.min(z, o);
    }
}