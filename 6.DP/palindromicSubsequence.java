// if addition happens --> ( ) % MOD
// if subtraction happens ----> + MOD
// both happens ---> + MOD ) % MOD



class palindromicSubsequence{
    
    long MOD = 1000000007;

    // RETURN COUNT OF TOTAL PALINDROMIC SUBSEQUENCE
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


    // RETURNS LONGEST PALINDROMIC SUBSEQUENCE LENGTH
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int gap=0 ; gap<dp[0].length ; gap++){
            for(int i=0 , j=gap ; j<dp[0].length ; i++ , j++){
                if(gap == 0) dp[i][j] = 1;
                else if(gap == 1){
                    // eg : ab --> if equal --> ab is longest
                    //             else ------> either a or b is longest 
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                }
                else{
                    dp[i][j] = Integer.MIN_VALUE;
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1]; // 2 + middle part
                    }
                    else{
                        dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]); // niche-piche
                    }
                }
            }
        }

        return dp[0][dp[0].length-1];
    }
}

