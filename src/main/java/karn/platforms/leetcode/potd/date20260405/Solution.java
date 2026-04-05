package karn.platforms.leetcode.potd.date20260405;

//https://leetcode.com/problems/robot-return-to-origin/?envType=daily-question&envId=2026-04-05
//lc 657. Robot Return to Origin
public class Solution {
    public boolean judgeCircle(String moves) {
        int horizontals = 0, verticals = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                horizontals++;
            } else if (c == 'L') {
                horizontals--;
            } else if (c == 'U') {
                verticals++;
            } else {
                verticals--;
            }
        }
        return horizontals == 0 && verticals == 0;
    }
}