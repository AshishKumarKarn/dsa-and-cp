package karn.platforms.leetcode.potd.leetcode.date02022026;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minimumCostTestOne() throws FileNotFoundException {
        Solution solution = new Solution();
        File file = new File("src/main/resources/date02022026/input1.txt");
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();
        String[] parts = line.trim().split(",");
        int[] costs = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            costs[i] = Integer.parseInt(parts[i].trim());
        }
        assertEquals(1256971495284L, solution.minimumCost(costs, 5141, 7841));

    }

    @Test
    void minimumCostTestTwo() {
        Solution solution = new Solution();
        assertEquals(15, solution.minimumCost(new int[]{
                10, 1, 2, 2, 2, 1
        }, 4, 3));

    }
}