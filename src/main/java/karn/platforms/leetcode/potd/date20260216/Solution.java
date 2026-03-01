package karn.platforms.leetcode.potd.date20260216;

//https://leetcode.com/problems/reverse-bits/description/?envType=daily-question&envId=2026-02-16
public class Solution {
    public int reverseBits(int n) {
        int reverse = 0;
        int cnt = 0;
        while (cnt < 32) {
            reverse <<= 1;
            reverse |= (n & 1);
            n >>= 1;
            cnt++;
        }
        return reverse;
    }
}