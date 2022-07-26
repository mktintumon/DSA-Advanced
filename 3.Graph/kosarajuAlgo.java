import java.util.*;

class kosarajuAlgo{
    /*
        SCC --> strongly connected components

        * DFS from all vertices as root(with visited[])
        * Add vertices to the  stack in post order
        * Transpose graph (reverse the directed edges)
        * pop from stack and apply DFS again with printing/counting SCC
    */

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int v=0 ; v<V ; v++){
            if(visited[v] == false){
                dfs1(v , adj , visited , st);
            }
        }
        
        //transpose
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int v=0 ; v<V ; v++){
            transpose.add(new ArrayList<>());
        }
        
        for(int v=0 ; v<V ; v++){
            for(int nbr : adj.get(v)){
                transpose.get(nbr).add(v);
            }
        }
        
        int count = 0;
        boolean[] visited2 = new boolean[V];
        while(st.size() > 0){
            int v = st.pop();
            if(visited2[v] == false){
                dfs2(v , transpose , visited2);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs1(int v ,ArrayList<ArrayList<Integer>> adj ,boolean[] visited , Stack<Integer> st ){
        visited[v] = true;
        
        for(int nbr : adj.get(v)){
            if(visited[nbr] == false){
                dfs1(nbr , adj , visited , st);
            }
        }
        
        //post-order
        st.push(v);
    }
    
    public void dfs2(int v , ArrayList<ArrayList<Integer>> transpose ,boolean[] visited){
        visited[v] = true;
        
        for(int nbr : transpose.get(v)){
            if(visited[nbr] == false){
                dfs2(nbr , transpose , visited);
            }
        }
    }
}
