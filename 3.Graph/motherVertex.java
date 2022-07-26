import java.util.*;

class motherVertex{

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
        
        // vertices goes last in the stack will be mother vertices(return smallest)
        boolean[] visited = new boolean[V];
        int mv = -1;
        
        for(int v=0 ; v<V ; v++){
            if(visited[v] == false ){
                dfs(v , adj , visited);
                mv = v;  // --> potential motherVertex
            }
        }
        
        // now make visited false and traverse again with potential mv
        // if all comes true then its mother vertex else not
        
        Arrays.fill(visited , false);
        dfs(mv , adj , visited );
        
        for(int v=0 ; v<V ; v++){
            if(visited[v] == false){
                return -1;
            }
        }
        
        return mv;
    }
    
    public void dfs(int v , ArrayList<ArrayList<Integer>>adj , boolean[] visited){
        visited[v] = true;
        
        for(int nbr : adj.get(v)){
            if(visited[nbr] == false){
                dfs(nbr , adj , visited);
            }
        }
    }
}
