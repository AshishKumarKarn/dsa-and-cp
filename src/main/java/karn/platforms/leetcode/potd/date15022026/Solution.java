package karn.platforms.leetcode.potd.date15022026;

//https://leetcode.com/problems/add-binary/?envType=daily-question&envId=2026-02-15
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        //1111 1111 = 0
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 1) {
                sb.append(1);
            } else if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                sb.append(0);
                carry = 1;
            } else if ((a.charAt(i) == '1' || b.charAt(j) == '1') && carry == 1) {
                sb.append(0);
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                sb.append(1);
            } else if (carry == 1) {
                sb.append(1);
                carry = 0;
            } else {
                sb.append(0);
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (carry == 1 && a.charAt(i) == '1') {
                sb.append(0);
            } else if (a.charAt(i) == '1') {
                sb.append(1);
            } else if (carry == 1) {
                sb.append(1);
                carry = 0;
            } else {
                sb.append(0);
            }
            i--;
        }
        while (j >= 0) {
            if (carry == 1 && b.charAt(j) == '1') {
                sb.append(0);
            } else if (b.charAt(j) == '1') {
                sb.append(1);
            } else if (carry == 1) {
                sb.append(1);
                carry = 0;
            } else {
                sb.append(0);
            }
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}