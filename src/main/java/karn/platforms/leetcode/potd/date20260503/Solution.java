package karn.platforms.leetcode.potd.date20260503;
//https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2026-05-03
//lc 796. Rotate String
public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        goal += goal;
        return goal.contains(s);
    }
}