
// GFG -> n <= 500 (submitted)
// LC -> n <= 2000 (TLE)

class palindromePartition2{
    static int palindromicPartition(String s){
        int[][] dp = new int[s.length()][s.length()];
        
        for(int gap=0 ; gap<dp[0].length ; gap++){
            for(int i=0 , j=gap ; j<dp[0].length ; i++ , j++){
                if(gap == 0) dp[i][j] = 0;
                else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 0){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = Integer.MAX_VALUE;
                        for(int lk=gap , rk=1 ; lk>=1 ; lk-- , rk++){
                            int left = dp[i][j - lk];
                            int right = dp[i + rk][j];
                            
                            dp[i][j] = Math.min(dp[i][j] , left+right+1);
                        }
                    }
                }
            }
        }
        
        return dp[0][dp[0].length-1];
    }
}