package karn.platforms.leetcode.potd.date18022026;

public class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = n & 1;
        n >>= 1;
        while (n > 0) {
            int lsb = n & 1;
            if ((prevBit ^ lsb) == 0) {
                return false;
            }
            prevBit = lsb;
            n >>= 1;
        }
        return true;
    }
}