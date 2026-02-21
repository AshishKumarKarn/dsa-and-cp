package karn.platforms.leetcode.potd.date21022026;

import java.util.Set;

public class Solution {
    static Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

    public int countPrimeSetBits(int left, int right) {
        int num = left;
        int count = 0;
        while (num <= right) {
            if (hasPrimeOnes(num)) {
                count++;
            }
            num++;
        }
        return count;
    }

    private boolean hasPrimeOnes(int num) {
        int ones = 0;
        while (num > 0) {
            ones += num & 1;
            num >>= 1;
        }
        return isPrime(ones);
    }

    private boolean isPrime(int ones) {
        return primes.contains(ones);
    }

}