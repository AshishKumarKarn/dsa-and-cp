package karn.platforms.leetcode.potd.date20260420;
//https://leetcode.com/problems/two-furthest-houses-with-different-colors/?envType=daily-question&envId=2026-04-20
//lc. 2078. Two Furthest Houses With Different Colors
public class Solution {
    public int maxDistance(int[] colors) {
        //observation, either first element or last element will always be involved in comparison.
        int result = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[0]) {
                result = Math.max(result, i);
            }
            if (colors[i] != colors[colors.length - 1]) {
                result = Math.max(result, colors.length - i - 1);
            }
        }
        return result;
    }
}