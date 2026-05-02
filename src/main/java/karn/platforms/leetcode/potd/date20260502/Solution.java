package karn.platforms.leetcode.potd.date20260502;
//https://leetcode.com/problems/rotated-digits/?envType=daily-question&envId=2026-05-02
//lc 788. Rotated Digits
public class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        int count = 0;
        dp[0]=1;
        //case 1 valid but neutral (0,1,8), case 2 good number(2,5,6,9), case 3 invalid 3,4,7
        for (int i = 1; i <= n; i++) {
            int lastD = i % 10;
            int prevD = i / 10;
            if (lastD == 0 || lastD == 1 || lastD == 8) {
                dp[i] = dp[prevD];
            } else if (lastD == 2 || lastD == 5 || lastD == 6 || lastD == 9) {
                if (dp[prevD] == 1 || dp[prevD] == 2) {
                    dp[i] = 2;
                } else {
                    dp[i] = 3;
                }
            } else {
                dp[i] = 3;
            }
            //if the current number is good number then we will increase the count
            if (dp[i] == 2) {
                count++;
            }
        }
        return count;
    }
}