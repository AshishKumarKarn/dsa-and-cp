package karn.platforms.leetcode.hard.lc3013;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void minimumCost() {
        Solution solution = new Solution();
        assertEquals(15,
                solution.minimumCost(new int[]{10, 1, 2, 2, 2, 1}, 4, 3));
        assertEquals(36,
                solution.minimumCost(new int[]{10, 8, 18, 9}, 3, 1));
        assertEquals(5,
                solution.minimumCost(new int[]{1, 3, 2, 6, 4, 2}, 3, 3));
        assertEquals(15,
                solution.minimumCost(new int[]{10, 1, 2, 2, 2, 1}, 4, 3));

    }

    @Test
    @Disabled("Disabled to avoid long test runs during compilation")
    void largerTestCase1() throws Exception {
        Scanner sc = new Scanner(new File("src/main/resources/leetcode/hard/lc3013/tc1.txt"));
        String line = sc.nextLine();
        int[] array = Arrays.stream(line.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(sc.nextLine());
        int dist = Integer.parseInt(sc.nextLine());
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        long actual = solution.minimumCost(array, k, dist);
        long finished = System.currentTimeMillis() - startTime;
        System.out.printf("finished in %s", finished);
        assertEquals(1924430897177L, actual);
//        assertTrue(finished<400);

    }

    @Test
    @Disabled("Disabled to avoid long test runs during compilation")
    void largerTestCase2() throws Exception {
        Scanner sc = new Scanner(new File("src/main/resources/leetcode/hard/lc3013/tc2.txt"));
        String line = sc.nextLine();
        int[] array = Arrays.stream(line.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(sc.nextLine());
        int dist = Integer.parseInt(sc.nextLine());
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        long actual = solution.minimumCost(array, k, dist);
        long finished = System.currentTimeMillis() - startTime;
        System.out.printf("finished in %s ms", finished);
        assertEquals(8495921, actual);
//        assertTrue(finished<400);

    }
}