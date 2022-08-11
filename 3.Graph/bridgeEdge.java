import java.util.*;

class bridgeEdge{
    static int time;
    static int ans;
    
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d){
        boolean[] vis = new boolean[V];
        int[] discover = new int[V];
        int[] lowest = new int[V];
        
        time = 0;
        ans = 0;
        for(int i=0 ; i<V ; i++){
            if(vis[i] == false){
            dfs(adj, vis , discover , lowest , i , -1 , c , d);
            }
        }
        
       return ans;
    } 
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj ,boolean[] vis,int[] discover,int[] lowest ,int currVtx ,int parVtx , int c , int d){
        vis[currVtx] = true;
        discover[currVtx] = lowest[currVtx] = ++time;
        
        for(int v : adj.get(currVtx)){
            if(v == parVtx){
                continue;
            }
            else if(vis[v] == true){
                lowest[currVtx] = Math.min(discover[v] , lowest[currVtx]);
            }
            else{
                // non root elements --> work in post order
                
                dfs(adj , vis , discover , lowest , v , currVtx , c , d);
                lowest[currVtx] = Math.min(lowest[currVtx] , lowest[v]);
                
                // no sign of equal to(=)
                if(lowest[v] > discover[currVtx]){
                    if(c == v && d == currVtx || c == currVtx && d == v){
                        ans = 1;
                    }
                }
            }
        }
    }
}
