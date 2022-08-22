import java.util.*;

// implementing Comparable<Edge> instead of lambda exp will make code little faster

class criticalAndPseudoEdges {
    
    static class UnionFind{
        int[] parent;
        int[] rank;
        int comps = 0;
        
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            comps = n; // starting -> total component -> n
            
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        int find(int x){
            if(parent[x] == x){
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }
        
        boolean union(int X, int Y){
            int x = find(X);
            int y = find(Y);
            if(x == y){
                return false;
            }
            
            if(rank[x] < rank[y]){
                parent[x] = y;
            } else if(rank[y] < rank[x]){
                parent[y] = x;
            } else {
                parent[y] = x;
                rank[x]++;
            }
            
            //after union decrease components
            comps--;
            
            return true;
        }
        
        boolean isConnected(){
            return comps == 1;
        }
    }
    
    static class Edge {
        int u;
        int v;
        int wt;
        
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    
    public int buildMST(int n, int[][] edges, int[] edgeToSkip, int[] edgeToPick){
         PriorityQueue<Edge> pq = new PriorityQueue<>((a , b) ->{
             return a.wt - b.wt;
         });
         
        
        for(int[] edge : edges){
            //not adding both edges in PQ
            if(edge == edgeToSkip  || edge == edgeToPick ){
            continue;
            }
             
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            pq.add(new Edge(u, v, wt));
        }
         
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        
        // manually making set of edge which didnt added in PQ
        if(edgeToPick != null){
            uf.union(edgeToPick[0], edgeToPick[1]);
            cost += edgeToPick[2];
        }
         
         while(pq.size() > 0){
            Edge rem = pq.remove();
            if(uf.union(rem.u, rem.v) == true){
                cost += rem.wt;
            }
         }
         
         if(uf.isConnected() == true){
            return cost;
        } else {
            // set hi nhi bna -> NO MST FOUND
            return Integer.MAX_VALUE;
        }
     }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int costMST = buildMST(n , edges , null , null);
        
        // adding idxes in the ans
        ArrayList<Integer> critical = new ArrayList<>();
        ArrayList<Integer> pseudo = new ArrayList<>();
        
        for(int i=0 ; i<edges.length ; i++){
            int[] edge = edges[i];
            
            int costMSTwithoutEdge = buildMST(n , edges , edge , null);
            if(costMSTwithoutEdge > costMST){
                critical.add(i);
            }
            else{
                int costMSTwithEdge = buildMST(n , edges , null , edge);
                if(costMSTwithEdge == costMST){
                    pseudo.add(i);
                }
                else{
                    // (costMSTwithEdge > costMST)
                    // redundant edge -> can be removed
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo);
        return ans;
    }
}