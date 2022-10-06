class fencePainting{

    // here max 2 consecutive paints are allowed
    long countWays(int n,int k){
        long mod = 1000000007;
        
        if(n == 1) return k;
        
        long same = (k * 1);
        long diff = (k*(k-1)) % mod;
        long total = (same + diff)% mod;
        
        for(int i=3 ; i<=n ; i++){
            same = (diff * 1);
            diff = (total*(k-1))% mod;
            
            total = (same + diff)% mod;
        }
        
        return total;
    }
}
