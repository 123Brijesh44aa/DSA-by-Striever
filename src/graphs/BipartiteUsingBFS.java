package graphs;

import java.util.*;

public class Bipartite {

    // Bipartite graph :
    // color the graph with 2 color such that no adjacent nodes have same color.
    // Linear graph with no cycle are always Bipartite.
    // Every graph with even cycle length are always bipartite graph.
    // Every graph with odd cycle length can never be bipartite graph.

    // to check if a graph is Bipartite, We need to  use BFS with a Queue and Visited
    // ( but we will use color[] array instead of visited ).

    private boolean bfs(Integer i, Integer[] colored, List<List<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colored[i] = 0;
        while (!queue.isEmpty()){
            Integer n = queue.poll();
            for(Integer it : adj.get(n)){
                if (colored[it] == -1){
                    colored[it] = 1 - colored[n];
                    queue.add(it);
                }
                else if (colored[it] == colored[n]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int v, int[][] edges){
        // initializing adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        // creating adjacency list
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Integer[] colored = new Integer[v];
        Arrays.fill(colored,-1);

        for (int i = 0; i<adj.size(); i++){
            if (colored[i] == -1){
                if (!bfs(i,colored,adj)){
                    return false ;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
