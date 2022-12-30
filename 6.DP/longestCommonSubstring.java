class longestCommonSubstring{

    int longestCommonSubstr(String s1, String s2, int n, int m){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        int ans = 0;
        for(int i=1 ; i<dp.length ; i++){
            for(int j=1 ; j<dp[0].length ; j++){
                // 0th row and column will have zero
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
                
                ans = Math.max(ans , dp[i][j]);
            }
        }
        
        return ans;
    }
}