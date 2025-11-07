package graphs;

import java.util.Arrays;

public class BipartiteUsingDFS {
    private boolean dfs(int i, int color, int[] colored, int[][]graph){
        colored[i] = color;
        for(int it : graph[i]){
            if(colored[it] == -1){
                if(!dfs(it, 1 - color, colored, graph)){
                    return false;
                }
            } else if(colored[it] == color){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph){
        int v = graph.length;
        int[] colored = new int[v];
        Arrays.fill(colored, -1);

        for(int i = 0; i<v; i++){
            if(colored[i] == -1){
                if(!dfs(i, 0, colored, graph)){
                    return false;
                }
            }
        }

        return true;
    }
}
