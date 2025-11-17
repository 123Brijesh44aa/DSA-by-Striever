package graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraphUsingDFS {
    // Problem Statement :
    // Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
    //The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

//    Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]
//    Output: true
//    Explanation: The diagram clearly shows a cycle 0 → 1 → 2 → 0

//    Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
//    Output: false
//    Explanation: no cycle in the graph

    private boolean dfs(int i, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited){
        visited[i] = true;
        pathVisited[i] = true;

        for(int v : adj.get(i)){
            if(visited[v] == false && dfs(v,adj,visited,pathVisited)){
                return true;
            } else if (pathVisited[v] == true){
                return true;
            }
        }

        pathVisited[i] = false;

        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
