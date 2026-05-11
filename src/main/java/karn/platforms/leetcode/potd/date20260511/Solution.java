package karn.platforms.leetcode.potd.date20260511;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//https://leetcode.com/problems/separate-the-digits-in-an-array/?envType=daily-question&envId=2026-05-11
//lc 2553. Separate the Digits in an Array
public class Solution {

    public int[] separateDigits(int[] nums) {
        return Arrays.stream(nums).flatMap(this::process).toArray();
    }

    private IntStream process(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list.reversed().stream().mapToInt(a->a);
    }
}