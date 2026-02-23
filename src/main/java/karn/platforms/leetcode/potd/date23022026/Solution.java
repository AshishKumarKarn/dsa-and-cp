package karn.platforms.leetcode.potd.date23022026;


public class Solution {

    public boolean hasAllCodes(String s, int k) {
        //own sol: Start with all number from 1-> 2^k as false
        boolean[] bins = new boolean[(1 << k)];
        int num = 0;
        for (int i = 0, left = 0; i < s.length() - k + 1; i++) {
            if (i == 0) {
                num = buildNumber(s.substring(0, k));
            } else {
                num = updateNumber(s.charAt(i - 1) - '0', k, num, s.charAt(i + k - 1) - '0');
            }
            bins[num] = true;
        }
        //if any number left then return false;
        for (boolean bin : bins) {
            if (!bin) {
                return false;
            }
        }
        return true;
    }

    private int updateNumber(int msb, int k, int num, int next) {
        if (msb != 0) {
            int msd = 1 << (k - 1);
            num -= msd;
        }

        num <<= 1;
        num |= next;
        return num;
    }

    private int buildNumber(String s) {
        return Integer.parseInt(s, 2);
    }
}