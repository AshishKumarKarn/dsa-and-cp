package karn.platforms.leetcode.potd.date20260408;

//https://leetcode.com/problems/xor-after-range-multiplication-queries-i/?envType=daily-question&envId=2026-04-08
//lc 3653. XOR After Range Multiplication Queries I
public class Solution {
    private static final long mod = (long) 1e9 + 7;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        long[] numsOp = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsOp[i] = nums[i];
        }
        for (int[] query : queries) {
            int idx = query[0];
            while (idx <= query[1]) {
                numsOp[idx] = (numsOp[idx] * query[3]) % mod;
                idx += query[2];
            }
        }

        long xor = numsOp[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= numsOp[i];
        }
        return (int) xor;
    }
}