import java.util.*;

class connectivityThreshold {
    
    // Brute approach -> find gcd -> not works
    // gcd with union and find -> will work
    
    int[] parent;
    int[] rank;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
         parent = new int[n+1];
         rank = new int[n+1];
        
        for(int i=0 ; i<=n ; i++){
            parent[i] = i;
            rank[i] = 0;
        } 
        
        // start union of vertices > threshold -> with there multiples
        for(int div=threshold+1 ; div<=n ; div++){
            for(int m=1 ; div*m <= n ; m++){
                union(div , div*m);
            }
        }
        
        ArrayList<Boolean> ans = new ArrayList<>();
        
        for(int[] query : queries){
            int x = find(query[0]);
            int y = find(query[1]);
            
            boolean flag = (x == y);
            ans.add(flag);
        }
        
        return ans;
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void union(int x , int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl == yl){
            return;
        }
        
        if(rank[yl] < rank[xl]){
            parent[yl] = xl;
        }
        else if(rank[yl] > rank[xl]){
            parent[xl] = yl;
        }
        else{
            parent[yl] = xl;
            rank[xl]++;
        }
        
    }
}