package karn.platforms.leetcode.potd.date20260415;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/?envType=daily-question&envId=2026-04-15
//lc 2515. Shortest Distance to Target String in a Circular Array
public class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if (words[startIndex].equals(target)) {
            return 0;
        }
        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                idxs.add(i);
            }
        }
        if (idxs.isEmpty()) {
            return -1;
        }
        int dis = n;
        for (int i : idxs) {
            if (i > startIndex) {
                dis = Math.min(dis, Math.min(i - startIndex, n - i + startIndex));
            } else {
                dis = Math.min(dis, Math.min(startIndex - i, n - startIndex + i));
            }
        }
        return dis;

    }
}
