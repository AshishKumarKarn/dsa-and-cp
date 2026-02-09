package karn.platforms.leetcode.medium.lc3835;

import org.junit.jupiter.api.Test;


class SolutionTest {

    @Test
    void countSubarrays() {
        int[] arr = new int[]{1,2,3};
        int k = 0;
        Solution solution = new Solution();
        long l = solution.countSubarrays(arr, k);
        System.out.println(l);
        arr = new int[]{1,3,2};
        k =4;
        l = solution.countSubarrays(arr, k);
        System.out.println(l);
    }
}