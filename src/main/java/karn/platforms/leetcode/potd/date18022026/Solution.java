package karn.platforms.leetcode.potd.date18022026;

public class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean prevBitSet = false;
        int prevBit = 0;
        while (n > 0) {
            int currentLastBit = (n & 1);
            if (!prevBitSet) {
                prevBitSet = true;
                prevBit = currentLastBit;
                n >>= 1;
                continue;
            }
            if ((currentLastBit ^ prevBit) == 0) {
                return false;
            }
            prevBit = currentLastBit;
            n >>= 1;
        }
        return true;
    }
}