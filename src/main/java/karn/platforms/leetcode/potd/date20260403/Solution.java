package karn.platforms.leetcode.potd.date20260403;

import java.util.Arrays;
import java.util.TreeMap;

//todo unsolved;
public class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        TreeMap<Integer, long[]> ranges = new TreeMap<>();
        Robot[] robs = new Robot[robots.length];
        for (int i = 0; i < robots.length; i++) {
            robs[i] = new Robot(robots[i], distance[i]);
        }
        Arrays.sort(robs, (r1, r2) -> r1.position - r2.position);
        for (int i = 0; i < robs.length; i++) {
            if (i == 0) {
                if (robs.length == 1) {
                    ranges.put(robs[i].position, new long[]{robs[i].position - robs[i].distance,
                            robs[i].position + robs[i].distance});
                } else {
                    ranges.put(robs[i].position,
                            new long[]{robs[i].position - robs[i].distance,
                                    Math.min(robs[i].position + robs[i].distance, robs[i + 1].position)});
                }

            } else if (i == robots.length - 1) {
                ranges.put(robs[i].position,
                        new long[]{Math.max(robs[i - 1].position,
                                robs[i].position - robs[i].distance),
                                robs[i].position + robs[i].distance});
            } else {
                ranges.put(robs[i].position,
                        new long[]{Math.max(robs[i - 1].position,
                                robs[i].position - robs[i].distance),
                                Math.min(robs[i + 1].position,
                                        robs[i].position + robs[i].distance)});
            }
        }
        int result = 0;
        for (int wall : walls) {
            if (canBeDestroyed(wall, ranges)) {
                result++;
            }
        }
        return result;

    }

    private boolean canBeDestroyed(int wall, TreeMap<Integer, long[]> ranges) {
        Integer floor = ranges.floorKey(wall);
        if (floor != null) {
            long[] range = ranges.get(floor);
            if (wall >= range[0] && wall <= range[1]) {
                return true;
            }
        }
        Integer ceiling = ranges.ceilingKey(wall);
        if (ceiling != null) {
            long[] range = ranges.get(ceiling);
            if (wall >= range[0] && wall <= range[1]) {
                return true;
            }
        }
        return false;
    }

    class Robot {
        int position;
        int distance;

        Robot(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }
}