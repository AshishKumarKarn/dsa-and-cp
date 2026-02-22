package karn.platforms.leetcode.contests.weekly490;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-sequences-to-k/
public class Problem4 {

    public int countSequences(int[] nums, long k) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, 1L, 1L, k, memo);
    }

    private int dfs(int[] nums, int i, long num, long den, long k, Map<String, Integer> memo) {
        // Reduce fraction
        long g = gcd(Math.abs(num), Math.abs(den));
        num /= g;
        den /= g;

        String key = i + "#" + num + "/" + den;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (i == nums.length) {
            // Check if final value == k
            if (num == k && den == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        int x = nums[i];
        int ways = 0;

        // 1) Skip
        ways += dfs(nums, i + 1, num, den, k, memo);

        // 2) Multiply
        ways += dfs(nums, i + 1, num * x, den, k, memo);

        // 3) Divide (rational)
        ways += dfs(nums, i + 1, num, den * x, k, memo);

        memo.put(key, ways);
        return ways;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}