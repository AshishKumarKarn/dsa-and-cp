package karn.platforms.leetcode.potd.date20260425;

import java.util.Arrays;
//https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/description/?envType=daily-question&envId=2026-04-25
//lc 3464. Maximize the Distance Between Points on a Square
public class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        long[] arr = new long[points.length];
        int i = 0;
        for (int[] p : points) {
            long x = p[0];
            long y = p[1];
            if (y == 0) {
                arr[i++] = x;
            } else if (x == 0) {
                arr[i++] = 4L * side - y;
            } else if (y == side) {
                arr[i++] = 3L * side - x;
            } else {
                arr[i++] = side + y;
            }
        }
        Arrays.sort(arr);

        long lo = 1;
        long hi = side;
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(arr, side, k, mid)) {
                lo = mid + 1;
                ans = mid;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

    private boolean check(long[] arr, int side, int k, long limit) {
        long perimeter = side * 4L;

        for (long start : arr) {
            long end = start + perimeter - limit;
            long cur = start;

            for (int i = 0; i < k - 1; i++) {
                int idx = lowerBound(arr, cur + limit);
                if (idx == arr.length || arr[idx] > end) {
                    cur = -1;
                    break;
                }
                cur = arr[idx];
            }

            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }

    //returns the index of the first element in arr that is greater than or equal to target
    private int lowerBound(long[] arr, long target) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = arr.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}