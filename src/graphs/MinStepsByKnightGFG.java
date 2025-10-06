package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinStepsByKnightGFG {

    // problem statement :  
    // Given a square chessboard of size (n x n), the initial position and target postion of Knight are given. Find out the minimum steps a Knight will take to reach the target position.
// Note: The initial and the target position coordinates of Knight have been given according to 1-base indexing.
// Examples:
// Input: n = 3, knightPos[] = [3, 3], targetPos[]= [1, 2]
// Output: 1
// Explanation:
// Knight takes 1 step to reach from 
// (3, 3) to (1 ,2).
// Input: n = 6, knightPos[] = [4, 5],targetPos[] = [1, 1]
// Output: 3
// Explanation:
// Knight takes 3 step to reach from 
// (4, 5) to (1, 1):
// (4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
// Constraints:
// 1 <= n<= 1000
// 1 <= knightpos ≤ [x, y], targertpos[x, y] ≤  n 
    private static int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        int knightR = knightPos[0] - 1;
        int knightC = knightPos[1] - 1;
        int targetR = targetPos[0] - 1;
        int targetC = targetPos[1] - 1;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList();
        int directions[][] = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {2, 1}};
        visited[knightR][knightC] = true;
        queue.offer(new int[]{knightR, knightC, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];
            if (r == targetR && c == targetC) {
                return steps;
            }
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, steps + 1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
