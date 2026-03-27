package karn.platforms.leetcode.potd.date20260327;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/equal-sum-grid-partition-ii/description/
//lc 3548. Equal Sum Grid Partition II
public class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        long totalSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                totalSum += grid[i][j];

            }
        }
        long sum = 0;
        Set<Long> set = new HashSet<>();
        if (grid.length == 1) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[0][j];
                long anotherSum = totalSum - sum;
                if (anotherSum == sum) {
                    return true;
                }
                long diff = sum - anotherSum;
                if (grid[0][0] == diff || grid[0][j] == diff) {
                    return true;
                }
            }
            sum = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                sum += grid[0][j];
                long anotherSum = totalSum - sum;
                if (anotherSum == sum) {
                    return true;
                }
                long diff = sum - anotherSum;
                if (grid[0][grid[0].length - 1] == diff || grid[0][j] == diff) {
                    return true;
                }
            }
        }
        if (grid.length == 1) {
            return false;
        }
        sum = 0;
        if (grid[0].length == 1) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][0];
                long anotherSum = totalSum - sum;
                if (anotherSum == sum) {
                    return true;
                }
                long diff = sum - anotherSum;
                if (grid[0][0] == diff || grid[i][0] == diff) {
                    return true;
                }
            }
            sum = 0;
            for (int i = grid.length - 1; i >= 0; i--) {
                sum += grid[i][0];
                long anotherSum = totalSum - sum;
                if (anotherSum == sum) {
                    return true;
                }
                long diff = sum - anotherSum;
                if (grid[grid.length - 1][0] == diff || grid[i][0] == diff) {
                    return true;
                }
            }
        }
        if (grid[0].length == 1) {
            return false;
        }
        sum = 0;
        set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
                set.add((long) grid[i][j]);
                if (j == grid[i].length - 1) {
                    long anotherSum = totalSum - sum;
                    if (anotherSum == sum) {
                        return true;
                    }
                    long diff = sum - anotherSum;
                    if (i == 0) {
                        //only one row so third condition applies
                        if (diff == grid[0][0] || diff == grid[i][j]) {
                            return true;
                        }
                    } else {
                        if (set.contains(diff)) {
                            return true;
                        }
                    }
                }
            }
        }
        sum = 0;
        set = new HashSet<>();
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
                set.add((long) grid[i][j]);
                if (j == grid[i].length - 1) {
                    long anotherSum = totalSum - sum;
                    if (anotherSum == sum) {
                        return true;
                    }
                    long diff = sum - anotherSum;
                    if (i == grid.length - 1) {
                        //only one row so third condition applies
                        if (diff == grid[i][0] || diff == grid[i][j]) {
                            return true;
                        }
                    } else {
                        if (set.contains(diff)) {
                            return true;
                        }
                    }
                }
            }
        }

        sum = 0;
        set = new HashSet<>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
                set.add((long) grid[i][j]);
                if (i == grid.length - 1) {
                    long anotherSum = totalSum - sum;
                    if (anotherSum == sum) {
                        return true;
                    }
                    long diff = sum - anotherSum;
                    if (j == 0) {
                        //only one row so third condition applies
                        if (diff == grid[0][0] || diff == grid[i][j]) {
                            return true;
                        }
                    } else {
                        if (set.contains(diff)) {
                            return true;
                        }
                    }
                }
            }
        }

        sum = 0;
        set = new HashSet<>();
        for (int j = grid[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
                set.add((long) grid[i][j]);
                if (i == grid.length - 1) {
                    long anotherSum = totalSum - sum;
                    if (anotherSum == sum) {
                        return true;
                    }
                    long diff = sum - anotherSum;
                    if (j == grid[0].length - 1) {
                        //only one row so third condition applies
                        if (diff == grid[0][j] || diff == grid[i][j]) {
                            return true;
                        }
                    } else {
                        if (set.contains(diff)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}