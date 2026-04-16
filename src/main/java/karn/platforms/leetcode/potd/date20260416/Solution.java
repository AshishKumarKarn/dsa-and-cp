package karn.platforms.leetcode.potd.date20260416;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/closest-equal-element-queries/description/?envType=daily-question&envId=2026-04-16
//lc 3488. Closest Equal Element Queries
public class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        //1 3 1 4 1 3 2, 1 3 1 4 1 3 2 ->
        //1 -> 0, 2, 4, 7, 9, 11
        // 7/2 3
        Map<Integer, List<Integer>> occs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> existing = occs.getOrDefault(nums[i], new ArrayList<>());
            existing.add(i);
            occs.put(nums[i % nums.length], existing);
        }
        List<Integer> result = new ArrayList<>();
        for (int query : queries) {
            int element = nums[query];
            List<Integer> occ = occs.get(element);
            if (occ.size() == 1) {
                result.add(-1);
            } else {
                int ind = Collections.binarySearch(occ, query);
                if (ind == 0) {
                    result.add(Math.min(nums.length - occ.getLast() + occ.get(ind),
                            occ.get(ind + 1) - occ.get(ind)));
                } else {
                    if (ind == occ.size() - 1) {
                        result.add(Math.min(nums.length - occ.getLast() + occ.getFirst(),
                                occ.get(ind) - occ.get(ind - 1)));
                    } else {
                        result.add(Math.min(occ.get(ind + 1) - occ.get(ind), occ.get(ind) - occ.get(ind - 1)));
                    }
                }
            }
        }
        return result;
    }
}