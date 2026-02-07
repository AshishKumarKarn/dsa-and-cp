package karn.platforms.leetcode.potd.date07022026;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void minimumDeletions() throws FileNotFoundException {
        Solution solution = new Solution();
        Scanner sc = new Scanner(new File("src/main/resources/date07022026/input1.txt"));
        String line = sc.nextLine();
        long start = System.currentTimeMillis();
        assertEquals(3162, solution.minimumDeletions(line.trim()));
        assertTrue(System.currentTimeMillis() - start < 100);
    }
}