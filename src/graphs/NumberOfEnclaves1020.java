package graphs;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves1020 {

// problem statement : 
// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
// Example 1:
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
// Example 2:
// Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
// Output: 0
// Explanation: All 1s are either on the boundary or can reach the boundary.
    class Pair {

        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();
        // mark all boundry elements visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (grid[i][j] == 1) {
                        visited[i][j] = true;
                        queue.add(new Pair(i, j));
                    }
                }
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        // apply BFS 
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.r;
            int c = pair.c;
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
