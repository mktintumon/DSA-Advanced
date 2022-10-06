class consecutiveBinaryString {
    
    // this is for consecutive one not allowed
    long countStrings(int n) {
        long mod = (long)Math.pow(10,9)+7;
        
        long oneWale = 1;
        long zeroWale = 1;
        
        for(int i=2 ; i<=n ; i++){
            long newOneWale = zeroWale;
            long newZeroWale = (zeroWale + oneWale) % mod;
            
            oneWale = newOneWale;
            zeroWale = newZeroWale;
        }
        
        return (zeroWale + oneWale) % mod;
    }
}