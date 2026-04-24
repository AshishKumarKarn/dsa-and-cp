package karn.platforms.leetcode.potd.date20260424;

public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int distD = 0;
        int distU = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                distD--;
            } else if (c == 'R') {
                distD++;
            } else {
                distU++;
            }
        }
        return Math.abs(distD) + distU;
    }
}