package karn.platforms.leetcode.potd.date22022026;

//https://leetcode.com/problems/binary-gap/description/?envType=daily-question&envId=2026-02-22
public class Solution {
    public int binaryGap(int n) {
        int gap = 0;
        int maxGap = 0;
        boolean firstOne = false;
        while (n > 0) {
            int lsb = n & 1;
            if (lsb == 0 && firstOne) {
                gap++;
            } else if (firstOne) {
                maxGap = Math.max(gap + 1, maxGap);
                gap = 0;
            }
            if (!firstOne && lsb == 1) {
                firstOne = true;
            }
            n >>= 1;
        }
        return maxGap;
    }
}