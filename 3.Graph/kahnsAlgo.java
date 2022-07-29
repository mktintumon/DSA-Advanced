import java.util.*;

class kahnsAlgo{
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] topoSort = new int[V];
        
        // make array contains indegree count
        int[] inDegree = new int[V];
        for(int i=0 ; i<V ; i++){
            for(int nbr : adj.get(i)){
                inDegree[nbr]++;
            }
        }
        
        // indgree with count 0 ->> add to queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int v = 0; v < V; v++){
            if(inDegree[v] == 0){
                queue.add(v);
            }
        }
        
        
        // printing
        int idx = 0;
        while(queue.size() > 0){
            // remove from queue 
            // print/add 
            // decrease indegree of nbr  
            // check for 0 indegree and add to queue
            
            int v = queue.remove();
            topoSort[idx] = v;
            idx++;
            
            for(int nbr : adj.get(v)){
                inDegree[nbr]--;
                
                if(inDegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }
        
        return topoSort;
    }
}
