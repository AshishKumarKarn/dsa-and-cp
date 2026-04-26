package karn.platforms.leetcode.potd.date20260426;

//https://leetcode.com/problems/detect-cycles-in-2d-grid/?envType=daily-question&envId=2026-04-26
//lc 1559. Detect Cycles in 2D Grid
public class Solution {
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private static final String UP = "up";
    private static final String DOWN = "down";

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    boolean right = solve(grid, visited, i, j + 1, i, j, grid[i][j],
                            RIGHT);
                    boolean left = solve(grid, visited, i, j - 1, i, j, grid[i][j],
                            LEFT);
                    boolean down = solve(grid, visited, i + 1, j, i, j, grid[i][j],
                            DOWN);
                    boolean up = solve(grid, visited, i - 1, j, i, j, grid[i][j],
                            UP);
                    if (right || down || up || left) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean solve(char[][] grid, boolean[][] visited, int i, int j, int si, int sj, char c, String dir) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != c) {
            return false;
        }
        if ((i == si && j == sj) || visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        boolean up = false;
        boolean down = false;
        boolean right = false;
        boolean left = false;
        switch (dir) {
            case RIGHT -> {
                up = solve(grid, visited, i - 1, j, si, sj, c, UP);
                down = solve(grid, visited, i + 1, j, si, sj, c, DOWN);
                right = solve(grid, visited, i, j + 1, si, sj, c, RIGHT);
            }
            case LEFT -> {
                up = solve(grid, visited, i - 1, j, si, sj, c, UP);
                down = solve(grid, visited, i + 1, j, si, sj, c, DOWN);
                left = solve(grid, visited, i, j - 1, si, sj, c, LEFT);
            }
            case DOWN -> {
                down = solve(grid, visited, i + 1, j, si, sj, c, DOWN);
                left = solve(grid, visited, i, j - 1, si, sj, c, LEFT);
                right = solve(grid, visited, i, j + 1, si, sj, c, RIGHT);
            }
            default -> {
                up = solve(grid, visited, i - 1, j, si, sj, c, UP);
                left = solve(grid, visited, i, j - 1, si, sj, c, LEFT);
                right = solve(grid, visited, i, j + 1, si, sj, c, RIGHT);
            }
        }

        return up || down || right || left;
    }
}