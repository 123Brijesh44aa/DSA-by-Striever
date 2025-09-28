package graphs;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges994 {

    // problem statement : 
    // You are given an m x n grid where each cell can have one of three values:
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
    class Pair {

        int first;
        int second;
        int time;

        public Pair(int first, int second, int time) {
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int freshCount = 0;

        // add all rotten oranges in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    freshCount += 1;
                }

            }
        }

        int tm = 0;
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        int count = 0;
        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int t = queue.peek().time;
            tm = Math.max(tm, t);
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
                        && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if (freshCount != count) {
            return -1;
        }

        return tm;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("oranges rotting : " + new RottingOranges994().orangesRotting(grid));
    }
}
