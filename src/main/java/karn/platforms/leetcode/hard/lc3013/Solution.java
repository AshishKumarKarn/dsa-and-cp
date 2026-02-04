package karn.platforms.leetcode.hard.lc3013;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        TreeSet<Item> treeSet = new TreeSet<>(
                (a,b) -> {
                    if(a.val == b.val) {
                        return a.index-b.index;
                    }
                    return Long.compare(a.val, b.val);
                }
        );
        long result = Long.MAX_VALUE;
        long sum = nums[0];
        Map<Integer, Item> map = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            Item item = new Item(i, nums[i]);
            map.put(i, item);
            if(i<=dist+1){
                treeSet.add(item);
            }
        }
        for(int i=1;i<nums.length;i++){

            long cSum = sum + calculateSum(treeSet, k-1);
            result = Math.min(result, cSum);
            if(i+dist>=nums.length){
                break;
            }
            if(i+dist+1<nums.length){
                Item toAdd = map.get(i+dist+1);
                treeSet.add(toAdd);
            }
            Item toRemove = map.get(i);
            treeSet.remove(toRemove);
        }
        return result;
    }
    private long calculateSum(TreeSet<Item> treeSet, int k){
        Iterator<Item> iterator = treeSet.iterator();
        long sum = 0;
        while(k>0&&iterator.hasNext()){
            Item i = iterator.next();
            sum += i.val;
            k--;
        }
        if(k>0){
            return Integer.MAX_VALUE;
        }
        return sum;
    }
    static class Item{
        int index;
        long val;
        Item(int index, long val){
            this.index = index;
            this.val = val;
        }
    }
}