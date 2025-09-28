package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {

    // problem descriptin : 
    // You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
// To perform a flood fill:
// Begin with the starting pixel and change its color to color.
// Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
// The process stops when there are no more adjacent pixels of the original color to update.
// Return the modified image after performing the flood fill.
// Example 1:
// Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
// Output: [[2,2,2],[2,2,0],[2,0,1]]
// Explanation:
// From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
// Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.
// Example 2:
// Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
// Output: [[0,0,0],[0,0,0]]
// Explanation:
// The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.
// Constraints:
// m == image.length
// n == image[i].length
// 1 <= m, n <= 50
// 0 <= image[i][j], color < 216
// 0 <= sr < m
// 0 <= sc < n
    class Pair {

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(int sr, int sc, boolean[][] visited, int[][] image, int color, int originalColor) {
        Queue<Pair> queue = new LinkedList<>();
        visited[sr][sc] = true;
        queue.add(new Pair(sr, sc));
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            int[] drow = {-1, 0, 0, 1};
            int[] dcol = {0, 1, -1, 0};
            for (int i = 0; i < 4; i++) {

                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && !visited[nrow][ncol] && image[nrow][ncol] == originalColor) {
                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = color;
                    queue.add(new Pair(nrow, ncol));

                }
            }

        }
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];
        boolean[][] visited = new boolean[n][m];
        if (!visited[sr][sc] && image[sr][sc] != color) {
            bfs(sr, sc, visited, image, color, originalColor);
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill733 fl = new FloodFill733();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1},};
        int sr = 1;
        int sc = 1;
        int color = 2;
        for (int[] row : fl.floodFill(image, sr, sc, color)) {
            System.out.println(Arrays.toString(row));
        }
    }
}
