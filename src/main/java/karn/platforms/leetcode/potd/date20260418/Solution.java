package karn.platforms.leetcode.potd.date20260418;

//https://leetcode.com/problems/mirror-distance-of-an-integer/?envType=daily-question&envId=2026-04-18
// lc 3783. Mirror Distance of an Integer
public class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        int num = 0;
        while (n > 0) {
            num *= 10;
            num += (n % 10);
            n /= 10;
        }
        return num;
    }
}