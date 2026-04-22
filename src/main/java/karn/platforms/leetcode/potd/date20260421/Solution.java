package karn.platforms.leetcode.potd.date20260421;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/?envType=daily-question&envId=2026-04-21
//1722. Minimize Hamming Distance After Swap Operations
public class Solution {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        parent = new int[source.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] allowedSwap : allowedSwaps) {
            int x = allowedSwap[0];
            int y = allowedSwap[1];
            union(x, y);
        }
        for (int i = 0; i < source.length; i++) {
            int p = find(i);
            Map<Integer, Integer> freq = map.getOrDefault(p, new HashMap<>());
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
            map.put(p, freq);
        }
        int distance = 0;
        for (int i = 0; i < target.length; i++) {
            int p = find(i);
            Map<Integer, Integer> freq = map.get(p);
            if (freq.containsKey(target[i])) {
                int cnt = freq.get(target[i]);
                if (cnt == 1) {
                    freq.remove(target[i]);
                } else {
                    freq.put(target[i], cnt - 1);
                }
            } else {
                distance++;
            }
        }
        return distance;
    }

    private int[] parent;

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootJ] = rootI;
        }
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
   /*
    public boolean connected(int i, int j, int[] parents) {
        return find(i, parents) == find(j, parents);
    }*/
}