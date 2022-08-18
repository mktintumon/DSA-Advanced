import java.util.*;

class findEventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0 ; i<graph.length ; i++){
            boolean safe = dfs(graph , i , vis);
            if(safe == true){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    public boolean dfs(int[][] graph , int v , int[] vis){
        if(vis[v] == 2){
            return true;
        }
        else if(vis[v] == 1){
            return false;
        }
        else{
            vis[v] = 1;
            
            for(int nbr : graph[v]){
                boolean safe = dfs(graph , nbr , vis);
                if(safe == false){
                    return false;
                }
            }
            
            // vertex have no nbr present - > terminal vertex
            //post order
            vis[v] = 2;
            return true;
        }
    }
}
