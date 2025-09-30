package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle1559 {
    // problem description : 
    // detect cycle in the graph

//     1559. Detect Cycles in 2D Grid
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
// A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
// Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
// Return true if any cycle of the same value exists in grid, otherwise, return false.
// Example 1:
// Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
// Output: true
// Explanation: There are two valid cycles shown in different colors in the image below:
// Example 2:
// Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
// Output: true
// Explanation: There is only one valid cycle highlighted in the image below:
// Example 3:
// Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
// Output: false
    class Pair {

        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private boolean isCycle(int node, boolean[] visited, List<List<Integer>> adj) {
        Queue<Pair> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(new Pair(node, -1));

        while (!queue.isEmpty()) {
            int source = queue.peek().node;
            int parent = queue.peek().parent;
            queue.remove();

            for (int i : adj.get(source)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new Pair(i, source));
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleBfs(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalNodes = rows * cols;

        // first we have to create a adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        // initialize all the List in the adj
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList<>());
        }
        // directions(up,down,left,right)
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int nodeId = row * cols + col;
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows
                            && newCol >= 0 && newCol < cols
                            && grid[row][col] == grid[newRow][newCol]) {
                        int neighborId = newRow * cols + newCol;
                        adj.get(nodeId).add(neighborId);
                    }
                }
            }
        }

        boolean[] visited = new boolean[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            if (!visited[i] && isCycle(i, visited, adj)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'b', 'a'},
            {'a', 'a', 'a', 'a'}
        };

        DetectCycle1559 obj = new DetectCycle1559();
        boolean hasCycle = obj.detectCycleBfs(grid);
        System.out.println("Cycle detected: " + hasCycle);
    }
}
