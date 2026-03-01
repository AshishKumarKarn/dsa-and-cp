package karn.platforms.leetcode.potd.date20260223;

public class SimplerSolution {

    public boolean hasAllCodes(String s, int k) {
        boolean[] bins = new boolean[(1 << k)];

        for (int i = 0; i < s.length() - k + 1; i++) {
            bins[Integer.parseInt(s.substring(i, i + k), 2)] = true;
        }
        for (boolean bin : bins) {
            if (!bin) {
                return false;
            }
        }
        return true;
    }
}