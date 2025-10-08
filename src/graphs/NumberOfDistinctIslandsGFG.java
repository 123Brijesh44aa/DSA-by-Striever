
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslandsGFG {

// problem statement : 
// Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
// Example 1:
// Input:
// grid[][] = [[1, 1, 0, 0, 0],
//             [1, 1, 0, 0, 0],
//             [0, 0, 0, 1, 1],
//             [0, 0, 0, 1, 1]]
// Output: 1
// Explanation:
// grid[][] = [[1, 1, 0, 0, 0], 
//             [1, 1, 0, 0, 0], 
//             [0, 0, 0, 1, 1], 
//             [0, 0, 0, 1, 1]]
// Same colored islands are equal. We have 2 equal islands, so we have only 1 distinct island.
// Example 2:
// Input:
// grid[][] = [[1, 1, 0, 1, 1],
//             [1, 0, 0, 0, 0],
//             [0, 0, 0, 0, 1],
//             [1, 1, 0, 1, 1]]
// Output: 3
// Explanation:
// grid[][] = [[1, 1, 0, 1, 1], 
//             [1, 0, 0, 0, 0], 
//             [0, 0, 0, 0, 1], 
//             [1, 1, 0, 1, 1]]
// Same colored islands are equal.
// We have 4 islands, but 2 of them
// are equal, So we have 3 distinct islands.
// Your Task: You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.
    static class Pair {

        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static String toString(int i, int j) {
        return Integer.toString(i) + " " + Integer.toString(j);
    }

    private static void bfs(int i, int j, List<String> list, boolean[][] visited, int[][] grid, Pair basePair) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        list.add(toString(i - basePair.r, j - basePair.c));
        queue.add(new Pair(i, j));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.r;
            int c = pair.c;

            int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                    list.add(toString(nr - basePair.r, nc - basePair.c));
                }
            }
        }
    }

    private static int countDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<List<String>> set = new HashSet<>();
        // initialize Lists in Set
        for (int i = 0; i < set.size(); i++) {
            set.add(new ArrayList<>());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    bfs(i, j, list, visited, grid, new Pair(i, j));
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

    }
}
