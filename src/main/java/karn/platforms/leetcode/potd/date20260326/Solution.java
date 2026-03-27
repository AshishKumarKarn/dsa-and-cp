package karn.platforms.leetcode.potd.date20260326;

import java.util.Arrays;

public class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[] rows =new long[grid.length];
        long[] cols = new long[grid[0].length];
        long sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                sum += grid[i][j];
                if(j==grid[i].length-1){
                    rows[i]=sum;
                }
            }
        }
        sum = 0;
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                sum += grid[i][j];
                if(i==grid.length-1){
                    cols[j]=sum;
                }
            }
        }
        long totalSum = rows[grid.length-1];
        if(totalSum%2==1){
            return false;
        }
        return (Arrays.binarySearch(rows, totalSum/2) >= 0) || (Arrays.binarySearch(cols, totalSum/2) >= 0);

    }
}