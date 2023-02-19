class wildcardPatternMatching { 
    
    public boolean isMatch(String str, String pat) {
        boolean[][] dp = new boolean[str.length()+1][pat.length()+1];
        
        int n = str.length();
        int m = pat.length();

        for(int i = n ; i>=0 ; i--){
            for(int j = m ; j>=0 ; j--){
                if(i == n && j == m){
                    dp[i][j] = true;
                }
                else if(i == n){
                    // last row
                    if(pat.charAt(j) == '*'){
                        dp[i][j] = dp[i][j+1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else if(j == m){
                    // last column
                    dp[i][j] = false;
                }
                else{
                    if(pat.charAt(j) == '?' || pat.charAt(j) == str.charAt(i)){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else if(pat.charAt(j) == '*'){
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }
                    else{
                        dp[i][j] = false; // first char not matched
                    }
                }
            }
        }

        return dp[0][0];
    }
}
