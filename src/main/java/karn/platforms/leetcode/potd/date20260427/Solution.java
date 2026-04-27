package karn.platforms.leetcode.potd.date20260427;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/?envType=daily-question&envId=2026-04-27
//lc 1391. Check if There is a Valid Path in a Grid
public class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> position = new LinkedList<>();
        position.add(new int[]{0, 0, grid[0][0]});//i,j, connection

        while (!position.isEmpty()) {
            int[] current = position.poll();
            int i = current[0];
            int j = current[1];
            int d = current[2];
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (d == 1) {
                //moves to right so the next cell should have left side open
                moveRight(grid, j, n, i, position);
                //moves to left so the next cell should have right side open
                moveLeft(grid, j, i, position);

            } else if (d == 2) {
                //moves to lower so the next cell should have up side open
                moveDown(grid, i, m, j, position);
                //moves to up so the next cell should have lower side open
                moveUp(grid, i, j, position);

            } else if (d == 3) {
                //moves to lower so the next cell should have up side open
                moveDown(grid, i, m, j, position);
                //moves to left so the next cell should have right side open
                moveLeft(grid, j, i, position);
            } else if (d == 4) {
                //moves to lower so the next cell should have up side open
                moveDown(grid, i, m, j, position);
                //moves to right so the next cell should have left side open
                moveRight(grid, j, n, i, position);
            } else if (d == 5) {
                //moves to left so the next cell should have right side open
                moveLeft(grid, j, i, position);
                //moves to up so the next cell should have lower side open
                moveUp(grid, i, j, position);
            } else {
                //moves to right so the next cell should have left side open
                moveRight(grid, j, n, i, position);
                //moves to up so the next cell should have lower side open
                moveUp(grid, i, j, position);

            }
        }
        return false;

    }

    private void moveUp(int[][] grid, int i, int j, Queue<int[]> position) {
        if (i != 0 && ((grid[i - 1][j] == 2) || (grid[i - 1][j] == 3) || (grid[i - 1][j] == 4))) {
            position.add(new int[]{i - 1, j, grid[i - 1][j]});
        }
    }

    private void moveDown(int[][] grid, int i, int m, int j, Queue<int[]> position) {
        if ((i != m - 1 && (grid[i + 1][j] == 2 || (grid[i + 1][j] != 5) || (grid[i + 1][j] != 6)))) {
            position.add(new int[]{i + 1, j, grid[i + 1][j]});
        }
    }

    private void moveLeft(int[][] grid, int j, int i, Queue<int[]> position) {
        if (j != 0 && ((grid[i][j - 1] == 1) || (grid[i][j - 1] == 4) || (grid[i][j - 1] == 6))) {
            position.add(new int[]{i, j - 1, grid[i][j - 1]});
        }
    }

    private void moveRight(int[][] grid, int j, int n, int i, Queue<int[]> position) {
        if (j != n - 1 && ((grid[i][j + 1] == 1) || (grid[i][j + 1] == 3) || (grid[i][j + 1] == 5))) {
            position.add(new int[]{i, j + 1, grid[i][j + 1]});
        }
    }
}