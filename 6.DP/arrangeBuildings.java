class arrangeBuildings{

    // LC - 2320 and GFG 
    // this is for consecutive zero not allowed
    public int TotalWays(int n){
        long mod = 1000000007;
        
        long oneWale = 1;
        long zeroWale = 1;
        
        for(int i=2 ; i<=n ; i++){
            long newZeroWale = oneWale % mod;
            long newOneWale = (zeroWale + oneWale) % mod;
            
            oneWale = newOneWale;
            zeroWale = newZeroWale;
        }
        
        long total=(oneWale+zeroWale)%mod;
        total=(total*total)%mod;

      return (int)total;
        
    }
}
