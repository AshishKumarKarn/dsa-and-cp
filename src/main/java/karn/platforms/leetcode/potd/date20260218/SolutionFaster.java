package karn.platforms.leetcode.potd.date20260218;

public class SolutionFaster {
    public boolean hasAlternatingBits(int n) {
        int xorRightShift = n^(n >> 1); //it should have all 1's for alternative bits
        return (xorRightShift & (xorRightShift+1)) == 0;//to check if all were 1's
    }
}