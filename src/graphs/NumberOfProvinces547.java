package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvinces547 {

    // problem statement
    // There are n cities. Some of them are connected, while some are not. If city a
    // is connected directly with city b, and city b is connected directly with city
    // c, then city a is connected indirectly with city c.

    // A province is a group of directly or indirectly connected cities and no other
    // cities outside of the group.

    // You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
    // ith city and the jth city are directly connected, and isConnected[i][j] = 0
    // otherwise.

    // Return the total number of provinces.

    // Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    // Output: 2
    // Example 2:

    // Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
    // Output: 3

    private static int findCircleNum(int[][] isConnected) {
        // we're given a matrix
        // we have to convert it to adjacency list / map

        int v = isConnected.length; // v = n = number of nodes
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // initialize every list in map
        for (int i = 0; i < v; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[v];
        int count = 0;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adj);
            }
        }

        return count;

    }

    private static void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> adj) {
        visited[node] = true;
        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println("total number of provinces : " + findCircleNum(isConnected));
    }
}
