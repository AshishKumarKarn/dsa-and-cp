package karn.platforms.leetcode.contests.weekly490;

//https://leetcode.com/problems/check-digitorial-permutation/
public class Problem2 {
    long[] facts = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public boolean isDigitorialPermutation(int n) {
        long num = n;
        long factSum = 0;
        while (n > 0) {
            int digit = n % 10;
            factSum += (facts[digit]);
            n /= 10;
        }
        //System.out.println(factSum);
        return hasSameDigits(factSum, (int) num);
    }

    private boolean hasSameDigits(long factSum, int n) {
        int[] cnts = new int[10];
        while (n > 0) {
            cnts[n % 10]++;
            n /= 10;
        }
        while (factSum > 0) {
            long ld = factSum % 10;
            cnts[(int) ld]--;
            factSum /= 10;
        }
        for (int c : cnts) {
            if (c != 0) {
                //System.out.println(c);
                return false;
            }
        }
        return true;
    }
}