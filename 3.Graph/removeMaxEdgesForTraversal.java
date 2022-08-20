
class removeMaxEdgesForTraversal {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for(int i = 1; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        int removeCount = 0;
        int e1 = 0;
        int e2 = 0;
        
        // making DSU using edge type 3 (both)
        for(int[] edge: edges){
            if(edge[0] == 3){
                boolean flag = union(parent, rank, edge[1], edge[2]);
                if(flag){
                    e1++;
                    e2++;
                } 
                else {
                    // in same set -> no need -> remove
                    removeCount++;
                }
            }
        }
        
        //Alice DSU
        int[] parentA = parent.clone();
        int[] rankA = rank.clone();
        for(int[] edge: edges){
            if(edge[0] == 1){
                boolean flag = union(parentA, rankA, edge[1], edge[2]);
                if(flag){
                    e1++;
                } else {
                    removeCount++;
                }
            }
        }
        
        // Bob DSU
        int[] parentB = parent.clone();
        int[] rankB = rank.clone();
        for(int[] edge: edges){
            if(edge[0] == 2){
                boolean flag = union(parentB, rankB, edge[1], edge[2]);
                if(flag){
                    e2++;
                } else {
                    removeCount++;
                }
            }
        }
        
        //acyclic path found in n-1 vertices required
        if(e1 == n - 1 && e2 == n - 1){
            return removeCount;
        } else {
            return -1;
        }
    }
    
    
    
    public int find(int[] parent , int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent , parent[x]);
            return parent[x];
        }
    }
    
    public boolean union(int[] parent, int[] rank, int x, int y){
        int x_Lead = find(parent , x);
        int y_Lead = find(parent , y);
        
        if(x_Lead == y_Lead){
            return false;
        }
        
        if(rank[x_Lead] < rank[y_Lead]){
            parent[x_Lead] = y_Lead;
        } 
        else if(rank[y] < rank[x_Lead]){
            parent[y_Lead] = x_Lead;
        } 
        else {
            parent[y_Lead] = x_Lead;
            rank[x_Lead]++;
        }
        
        return true;
    }
}
