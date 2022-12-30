
class countPalindromicSubseq{
    
    // if addition happens --> ( ) % MOD
    // if subtraction happens ----> + MOD
    // both happens ---> + MOD ) % MOD
    long MOD = 1000000007;
    
    long countPS(String str){
        long[][] dp = new long[str.length()][str.length()];
        
        for(int gap=0 ; gap<dp[0].length ; gap++){
            for(int i=0 , j=gap ; j<dp[0].length ; i++ ,j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    // this also handles by else case
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 3 : 2;
                }
                else{
                    //formula
                    long suffix = dp[i+1][j];
                    long prefix = dp[i][j-1];
                    long middle = dp[i+1][j-1];
                    
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = (suffix + prefix + 1) % MOD;
                    }
                    else{
                        dp[i][j] = (suffix + prefix - middle + MOD) % MOD;
                    }
                }
            }
        }
        
        return dp[0][dp[0].length-1];
    }
}
