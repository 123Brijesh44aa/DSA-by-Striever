package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    // DFS traversal of graph

    // Depth-First Search (DFS) is a graph traversal algorithm that explores as far
    // as possible along each branch before backtracking. It is used to
    // systematically visit all nodes in a graph or tree.

    // How DFS Works:
    // Start at a chosen node: Select an arbitrary starting node (or the root node
    // in a tree).

    // Mark as visited: Mark the current node as visited to prevent revisiting it
    // and getting caught in cycles.

    // Explore unvisited neighbors: For the current node, examine its adjacent
    // nodes. If an adjacent node is unvisited, recursively apply DFS to that
    // unvisited node.

    // Backtrack: When all neighbors of the current node have been visited (or there
    // are no unvisited neighbors), the algorithm backtracks to the previous node
    // and continues exploring from there.

    // Repeat: This process continues until all reachable nodes from the starting
    // node have been visited. If there are unvisited nodes in disconnected parts of
    // the graph, a new starting node is chosen from an unvisited component, and the
    // process repeats.

    private static void dfs(int node, List<Integer> list, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        list.add(node);
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, list, vis, adj);
            }
        }
    }

    private static List<Integer> dfsOfGraph(int v, List<List<Integer>> adj) {
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[v + 1]; // v = total number of nodes
        vis[0] = true;
        dfs(0, list, vis, adj);
        return list;
    }

    public static void main(String[] args) {

    }
}
