package karn.platforms.leetcode.potd.date27022026;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

//https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/description/?envType=daily-question&envId=2026-02-27
public class AnotherAwesomeSolution {

    public int minOperations(String s, int k) {
        int n = s.length();

        // Count zeros
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zeros++;
        }

        if (zeros == 0)
            return 0;

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // Separate states by parity
        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            sets[i % 2].add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(zeros);
        dist[zeros] = 0;

        // Remove initial state
        sets[zeros % 2].remove(zeros);

        while (!queue.isEmpty()) {

            int z = queue.poll();

            // Compute valid i range
            int lowerI = Math.max(0, k - (n - z));
            int upperI = Math.min(z, k);

            // Compute reachable zero range
            int left = z + k - 2 * upperI;
            int right = z + k - 2 * lowerI;

            // Choose correct parity set
            TreeSet<Integer> set = sets[left % 2];

            Integer next = set.ceiling(left);

            while (next != null && next <= right) {

                dist[next] = dist[z] + 1;

                if (next == 0) {
                    return dist[next];
                }

                queue.add(next);
                set.remove(next);

                next = set.ceiling(left);
            }
        }

        return -1;
    }
}