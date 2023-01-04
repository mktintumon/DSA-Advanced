import java.util.*;

// GFG

class Solution{
    static class Pair{
        int v;
        int wt;
        
        Pair(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
             return a.wt - b.wt;
        });
        
        pq.add(new Pair(S,0));
        ans[S] = 0;
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            for(int i=0 ; i<adj.get(rem.v).size() ; i++){
                ArrayList<Integer> nbrList = adj.get(rem.v).get(i);
                int nbrV = nbrList.get(0);
                int nbrWt = nbrList.get(1);
                
                // relaxation method
                if(rem.wt + nbrWt < ans[nbrV]){
                    ans[nbrV] = rem.wt + nbrWt;
                    pq.add(new Pair(nbrV , rem.wt+nbrWt));
                }
            }
        }
        
        return ans;
    }
}
