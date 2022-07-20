import java.util.*;

// both bfs and dfs call have same complexity

class isBipartite {
    public boolean is_Bipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int v=0 ; v<graph.length ; v++){
            if(visited[v] == 0){
                //dfs call
                boolean isBip = dfs(graph , visited , v , 1); // 1--->color
                if(isBip == false){
                    return false;
                }    
            }
        }
        return true;
    }
    

    // APPROACH - 1 ------>> DFS CALL 
    public boolean dfs(int[][] graph , int[] visited , int v , int color){
        visited[v] = color;
        
        for(int nbr : graph[v]){
            if(visited[nbr] == 0){
                boolean ans = dfs(graph , visited , nbr , color*(-1));
                if(ans == false){
                    return false;
                }
            }
            else{
                int presentColor = visited[nbr];
                int desiredColor = color*(-1);
                
                if(presentColor != desiredColor){
                    return false;
                }
            }
        }
        return true;
    }

    //  APPROACH - 2  ---> BFS CALL
    class Pair {
        int v;
        int color;
        
        Pair(int v, int color){
            this.v = v;
            this.color = color;
        }
    }
    public boolean traverseBFS(int[][] graph, int[] visited, int v){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        queue.add(new Pair(v, 1));
        while(queue.size() > 0){
            Pair rem = queue.remove();
            if(visited[rem.v] != 0){
                int oc = visited[rem.v];
                int nc = rem.color;
                
                if(oc == nc){
                    continue;
                } else {
                    return false;
                }
            }
            visited[rem.v] = rem.color;
            
            for(int nbr: graph[rem.v]){
                if(visited[nbr] == 0){
                    queue.add(new Pair(nbr, rem.color * -1));
                }
            }
        }
        
        return true;
    }
}