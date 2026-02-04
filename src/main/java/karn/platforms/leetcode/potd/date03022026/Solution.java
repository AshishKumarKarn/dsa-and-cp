package karn.platforms.leetcode.potd.date03022026;

class Solution {
    public boolean isTrionic(int[] nums) {
        int peak = -1;
        int peakCount = 0;
        int depth = -1;
        int depthCount = 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                peak = i;
                peakCount++;
            }
            if(nums[i]<nums[i-1]&&nums[i]<nums[i+1]){
                depth = i;
                depthCount++;
            }
            if(nums[i]==nums[i-1]||nums[i]==nums[i+1]){
                return false;
            }
        }
        return depthCount==1&&peakCount==1&&peak<depth;
    }
}
