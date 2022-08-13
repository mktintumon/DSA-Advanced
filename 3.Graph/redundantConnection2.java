import java.util.*;

class redundantConnection2 {
    int[] dsu;
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        
        boolean twoParents = false;
        int[] e1 = null;
        int[] e2 = null;
        
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            
            if(parent[to] == -1){
                // first parent coming...
                parent[to] = from;
            } 
            else {
                // double parent encountered
                twoParents = true;
                e2 = edges[i];
                e1 = new int[] {parent[to], to};
                break;
            }
        }       
        
        dsu = new int[edges.length + 1];
        for(int i = 0; i <= edges.length; i++){
            dsu[i] = i;    
        }
        
        if(twoParents == false){
            // single parent case -> edge creating the cycle is the answer 
            int[] ans = null;
            
            for(int i = 0; i < edges.length; i++){
                int from = edges[i][0];
                int to = edges[i][1];
                
                int fromLead = find(from);
                if(to == fromLead){
                    ans = edges[i];
                    break;
                } else {
                    dsu[to] = fromLead;
                }
            }
            
            return ans;
        } 
        else {
            //double parent case -> check for cycle -> never add e2
            boolean hasCycle = false;
            for(int i = 0; i < edges.length; i++){
                if(edges[i] == e2){
                    continue;
                }
                
                int from = edges[i][0];
                int to = edges[i][1];
                
                int fromLead = find(from);
                if(to == fromLead){
                    // cycle detected
                    hasCycle = true;
                    break;
                } else {
                    dsu[to] = fromLead;
                }
            }
            
             if(hasCycle == true){
                return e1;
            }
            else{
                // hasCycle == false
                return e2;
            }
        }
    }
    
    int find(int x){
        if(dsu[x] == x){
            return x;
        } else {
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }

}