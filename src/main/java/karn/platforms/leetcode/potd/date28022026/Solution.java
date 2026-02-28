package karn.platforms.leetcode.potd.date28022026;

//https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description/
public class Solution {
    private static final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            result = ((result << bits) + i) % MOD;
        }

        return (int) result;
    }
}