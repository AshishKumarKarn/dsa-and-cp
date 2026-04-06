package karn.platforms.leetcode.potd.date20260406;

import java.util.Arrays;
//https://leetcode.com/problems/walking-robot-simulation/?envType=daily-question&envId=2026-04-06
//lc 874. Walking Robot Simulation
public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0; // 0->N, 1-> E , 2-> S, 3 -> W
        int maxEd = 0;
        int x = 0, y = 0;
        Arrays.sort(obstacles, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int command : commands) {
            if (command == -1) {
                direction++;
                direction %= 4;

            } else if (command == -2) {
                direction--;
                if (direction == -1) {
                    direction = 3;
                }
            } else {
                for (int i = 0; i < command; i++) {
                    if (direction == 0) {
                        if (binarySearch(obstacles, x, y + 1)) {
                            break;
                        }
                        y++;
                    } else if (direction == 1) {
                        if (binarySearch(obstacles, x + 1, y)) {
                            break;
                        }
                        x++;
                    } else if (direction == 2) {
                        if (binarySearch(obstacles, x, y - 1)) {
                            break;
                        }
                        y--;
                    } else {
                        if (binarySearch(obstacles, x - 1, y)) {
                            break;
                        }
                        x--;
                    }
                }

                maxEd = Math.max(maxEd, (x * x) + (y * y));
            }
        }
        return maxEd;
    }

    private boolean binarySearch(int[][] obstacles, int x, int y) {
        int min = 0;
        int max = obstacles.length - 1;
        while (min <= max) {
            int mid = (min) + (max - min) / 2;
            int[] obs = obstacles[mid];
            if (obs[0] == x && obs[1] == y) {
                return true;
            } else if (obs[0] > x || (obs[0] == x && obs[1] > y)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}