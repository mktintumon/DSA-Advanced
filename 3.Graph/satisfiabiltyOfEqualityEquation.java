
class satisfiabiltyOfEqualityEquation {
    
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i=0 ; i<26 ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        // traversal for (==) equations
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                
                int srcLead = find(x);
                int nbrLead = find(y);
                
                if(srcLead != nbrLead){  
                    union(srcLead , nbrLead);
                }
            }
        }
        
        // traversal for (!=) equations
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                //convert char to int
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                
                int srcLead = find(x);
                int nbrLead = find(y);
                
                if(srcLead == nbrLead){
                   return false;
                }
            }
        }
        
        return true;
    }
    
    int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    void union(int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[y] < rank[x]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }
}
