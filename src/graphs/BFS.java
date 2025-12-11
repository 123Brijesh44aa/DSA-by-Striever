package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // BFS traversal technique

    // process :
    // 1. start from a source node
    // -> pick a starting node (say 1)

    // 2. use a queue
    // -> bfs uses a queue to keep track of nodes to visit

    // 3. mark the visiting node as visited
    // -> this prevents visiting the same node multiple times

    // 4. enqueue the starting node
    // -> put it in the queue

    // 5. repeat until queue is empty
    // -> dequeue (remove) a node from the front
    // -> process it (eg. print or store it)
    // -> Enqueue all its unvisited neighbors
    // -> mark these neighbors as visited

    // 6. End when all reachable nodes are visited.

    private static List<Integer> bfs(int v, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        vis[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll(); // remove front
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {

    }
}