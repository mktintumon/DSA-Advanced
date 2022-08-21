import java.util.*;

/*                    NOT CLEARED  --> CONFUSED                             */

class fordFulkersonAlgo {
    
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) { 
        int maxFlow = 0;
        
        // N -> vertices(1 ,2 ...N)  and M -> Edges
        // src -> 1  and dest -> N
        int[][] graph = new int[N+1][N+1];
        int[][] revGraph = new int[N+1][N+1];

        for(ArrayList<Integer> edge : Edges ){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            
            graph[u][v] += w;
            graph[v][u] += w;
            
            revGraph[u][v] += w;
            revGraph[v][u] += w;
        }
        
        int[] parent = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        while(pathFound(parent , revGraph , 1 , N , vis) == true){
            int flow = Integer.MAX_VALUE;
            
            int v = N; // dest

            //updatng flow
            while(v != 1){
                int pv = parent[v];
                int price = revGraph[pv][v]; // weight
                if(price < flow){
                    flow = price;
                }
                
                v = pv;
            }
            
            //updating revGraph
            v = N;
            while(v != 1){
                int pv = parent[v];
                revGraph[pv][v] -= flow;
                revGraph[v][pv] += flow;
                
                v = pv;
            }
            
            maxFlow += flow;
            vis = new boolean[N + 1]; // go and find another path
        }
        
        return maxFlow;
    }
    
    //DFS
    boolean pathFound(int[] parent , int[][] revGraph , int src , int dest , boolean[] vis){
        vis[src] = true;
        
        if(src == dest) return true;
        
        for(int v=1 ; v<revGraph.length ; v++){
            if(revGraph[src][v] > 0 && !vis[v]){
                parent[v] = src;
                boolean parFromChild = pathFound(parent, revGraph, v, dest, vis);
                
                if(parFromChild == true){
                    return true;
                }
            }
        }
        
        return false;
    }
}