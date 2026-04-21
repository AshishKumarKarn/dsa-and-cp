package karn.platforms.leetcode.potd.date20260421;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/?envType=daily-question&envId=2026-04-21
//1722. Minimize Hamming Distance After Swap Operations
public class Solution {
    private int[] rank;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int[] parents = new int[source.length];
        rank = new int[parents.length];
        Arrays.fill(rank, 1);
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] allowedSwap : allowedSwaps) {
            int x = allowedSwap[0];
            int y = allowedSwap[1];
            union(x, y, parents);
        }
        for (int i = 0; i < source.length; i++) {
            int p = find(i, parents);
            Map<Integer, Integer> freq = map.getOrDefault(p, new HashMap<>());
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
            map.put(p, freq);
        }
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            int p = find(i, parents);
            Map<Integer, Integer> freq = map.get(p);
            if (freq.containsKey(target[i])) {
                int cnt = freq.get(target[i]);
                if (cnt == 1) {
                    freq.remove(target[i]);
                } else {
                    freq.put(target[i], cnt - 1);
                }
            } else {
                count++;
            }
        }
        return count;
    }

    private void union(int i, int j, int[] parent) {
        int rootI = find(i, parent);
        int rootJ = find(j, parent);
        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
                rank[rootJ]++;
            }
        }
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
   /*
    public boolean connected(int i, int j, int[] parents) {
        return find(i, parents) == find(j, parents);
    }*/
}