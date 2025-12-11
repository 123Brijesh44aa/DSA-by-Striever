package graphs;
import java.util.LinkedList;
import java.util.Queue;

public class ReplaceOsWithXsGFGORSurroundedRegions130 {

    // problem statement : 
    // Given a matrix mat where every element is either 'O' or 'X'. Replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.
// A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.
// Examples:
// Input: mat = 
// [['X', 'X', 'X', 'X'], 
// ['X', 'O', 'X', 'X'], 
// ['X', 'O', 'O', 'X'], 
// ['X', 'O', 'X', 'X'], 
// ['X', 'X', 'O', 'O']]
// Output: 
// [['X', 'X', 'X', 'X'], 
// ['X', 'X', 'X', 'X'], 
// ['X', 'X', 'X', 'X'], 
// ['X', 'X', 'X', 'X'], 
// ['X', 'X', 'O', 'O']]
// Explanation: We only changed those 'O' that are surrounded by 'X'
// Input: mat = 
// [['X', 'O', 'X', 'X'], 
// ['X', 'O', 'X', 'X'], 
// ['X', 'O', 'O', 'X'], 
// ['X', 'O', 'X', 'X'], 
// ['X', 'X', 'O', 'O']]
// Output: 
// [['X', 'O', 'X', 'X'], 
// ['X', 'O', 'X', 'X'], 
// ['X', 'O', 'O', 'X'], 
// ['X', 'O', 'X', 'X'], 
// ['X', 'X', 'O', 'O']]
// Explanation: There's no 'O' that's surround by 'X'.
// Input: mat = 
// [['X', 'X', 'X'], 
// ['X', 'O', 'X'], 
// ['X', 'X', 'X']]
// Output: 
// [['X', 'X', 'X'], 
// ['X', 'X', 'X'], 
// ['X', 'X', 'X']]
// Explanation: There's only one 'O' that's surround by 'X'.
// Constraints:
// 1 ≤ mat.size() ≤ 100
// 1 ≤ mat[0].size() ≤ 100
    static class Pair {

        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static char[][] fill(char[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();
        char[][] output = new char[rows][cols];
        // add all the O's in the Queue which are on the boundry
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (mat[i][j] == 'O') {
                        queue.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }

        // apply BFS on every 'O'
        int[][] directions = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.r;
            int c = pair.c;
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && mat[nr][nc] == 'O') {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    output[i][j] = 'X';
                }
                output[i][j] = 'O';
            }
        }

        return output;
    }

    public static void main(String[] args) {

    }
}
