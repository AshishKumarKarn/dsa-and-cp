package karn.platforms.leetcode.contests.weekly490;

//https://leetcode.com/problems/maximum-bitwise-xor-after-rearrangement/description/
public class Problem3 {
    public String maximumXor(String s, String t) {
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (countZero > 0) {
                    countZero--;
                    sb.append(1);
                } else {
                    countOne--;
                    sb.append(0);
                }
            } else {
                if (countOne > 0) {
                    countOne--;
                    sb.append(1);
                } else {
                    countZero--;
                    sb.append(0);
                }
            }
        }
        return sb.toString();
    }
}