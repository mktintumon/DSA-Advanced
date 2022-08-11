import java.util.*;

class articulationPoint{
    
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj){
        HashSet<Integer> ap = new HashSet<>();
        boolean[] vis = new boolean[V];
        int[] discover = new int[V];
        int[] lowest = new int[V];
        
        for(int i=0 ; i<V ; i++){
            if(vis[i] == false){
            dfs(adj , ap , vis , discover , lowest , i , -1);
            }
        }
        
        int[] ans = new int[ap.size()];
        int idx = 0;
        for(int i : ap){
            ans[idx] = i;
            idx++;
        }
        
        if(ap.size() == 0){
            ans = new int[] {-1};
        }
        
        Arrays.sort(ans);
        
        return ans;
    } 
    
    
    int time = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj ,HashSet<Integer> ap, boolean[] vis,int[] discover,int[] lowest ,int currVtx ,int parVtx){
        vis[currVtx] = true;
        discover[currVtx] = lowest[currVtx] = ++time;
        
        int childCount = 0;
        for(int v : adj.get(currVtx)){
            if(v == parVtx){
                continue;
            }
            else if(vis[v] == true){
                lowest[currVtx] = Math.min(discover[v] , lowest[currVtx]);
            }
            else{
                // non root elements --> work in post order
                childCount++;
                
                dfs(adj ,ap , vis , discover , lowest , v , currVtx);
                lowest[currVtx] = Math.min(lowest[currVtx] , lowest[v]);
                
                if(parVtx != -1 && discover[currVtx] <= lowest[v]){
                    ap.add(currVtx);
                }
            }
        }
        
        // root element
        if(parVtx == -1 && childCount > 1){
            ap.add(currVtx);
        }
    }
}
