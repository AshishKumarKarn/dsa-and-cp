package karn.platforms.leetcode.potd.date20260226;

public class Solution {
    public int numSteps(String s) {
        //11100111 -1
        //11101000 -3
        char[] chars = s.toCharArray();
        int j = chars.length - 1;
        int count = 0;
        while (j >= 1) {
            if (chars[j] == '1') {
                while (j >= 0 && chars[j] != '0') {
                    count++;
                    j--;
                }
                count++;
                if (j >= 0) {
                    chars[j] = '1';
                }
            } else {
                while (j >= 0 && chars[j] != '1') {
                    count++;
                    j--;
                }
            }
        }
        return count;
    }
}