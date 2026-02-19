package karn.platforms.leetcode.potd.date19022026;

public class Solution {
    public int countBinarySubstrings(String s) {
        char start = s.charAt(0);
        boolean canStartZero = start == '1';
        boolean canStartOne = !canStartZero;
        int countZero = canStartZero ? 0 : 1;
        int countOne = canStartOne ? 0 : 1;
        int result = 0;
        for (int i = 1; i < s.length(); ) {
            char ch = s.charAt(i);
            if (ch == '0' && canStartZero) {
                int j = i;
                while (j < s.length() && s.charAt(j) == '0') {
                    countZero++;
                    j++;
                }
                result += Math.min(countZero, countOne);
                if (j == s.length()) {
                    break;
                }
                countOne = 0;
                canStartOne = true;
                canStartZero = false;
                i = j;
            } else if (ch == '0') {//canStartOne is true
                countZero++;
                i++;
            } else if (ch == '1' && canStartOne) {//do calculation
                int j = i;
                while (j < s.length() && s.charAt(j) == '1') {
                    countOne++;
                    j++;
                }
                result += Math.min(countZero, countOne);
                if (j == s.length()) {
                    break;
                }
                countZero = 0;
                canStartOne = false;
                canStartZero = true;
                i = j;
            } else if (ch == '1') {//canStartZero is true
                countOne++;
                i++;
            }
        }
        return result;
    }
}