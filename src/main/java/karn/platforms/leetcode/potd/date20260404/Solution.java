package karn.platforms.leetcode.potd.date20260404;

//https://leetcode.com/problems/decode-the-slanted-ciphertext/?envType=daily-question&envId=2026-04-04
//lc 2075. Decode the Slanted Ciphertext
public class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int length = encodedText.length();
        if (length == 0) {
            return encodedText;
        }
        int cols = length / rows;
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < length; i++) {
            int r = i / (cols);
            int c = i % (cols);
            matrix[r][c] = encodedText.charAt(i);
        }
        int i = 0;
        int startCol = 0;
        int j = startCol++;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(matrix[i][j]);
            if (i == 0 && j == cols - 1) {
                break;
            }
            i++;
            j++;
            if (i == rows || j == cols) {
                i = 0;
                j = startCol++;
            }
        }
        int li = sb.length() - 1;
        while (sb.charAt(li) == ' ') {
            li--;
        }
        return sb.substring(0, li + 1);
    }
}
