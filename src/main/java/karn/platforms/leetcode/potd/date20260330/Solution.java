package karn.platforms.leetcode.potd.date20260330;
//https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/?envType=daily-question&envId=2026-03-30
//lc 2840. Check if Strings Can Be Made Equal With Operations II
public class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] odds = new int[26];
        int[] evens = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evens[s1.charAt(i) - 'a']++;
                evens[s2.charAt(i) - 'a']--;
            } else {
                odds[s1.charAt(i) - 'a']++;
                odds[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (odds[i] != 0 || evens[i] != 0) {
                return false;
            }
        }
        return true;
    }
}