

class palindromePartition2{
    
    
    // O(n^3)
    // GFG -> n <= 500 (submitted)  
    // LC -> n <= 2000 (TLE)
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


    // O(n^2) 
    // LC -> submitted
    // GFG -> submitted
    boolean[][] isPal;

    void isPalindrome(String s){
        isPal = new boolean[s.length()][s.length()];

        for(int gap=0 ; gap<isPal[0].length ; gap++){
            for(int i=0 , j=gap ; j<isPal[0].length ; i++ , j++){
                if(gap == 0) isPal[i][j] = true;
                else if(gap == 1) isPal[i][j] = (s.charAt(i) == s.charAt(j));
                else{
                    isPal[i][j] = (s.charAt(i) == s.charAt(j)) && (isPal[i+1][j-1] == true);
                }
            }
        }
    }

    public int minCut(String s) {
        if(s.length() <= 1) return 0;

        isPalindrome(s);
        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = s.charAt(0) == s.charAt(1) ? 0 : 1;

        for(int j=2 ; j<dp.length ; j++){
            dp[j] = j; // each cell of dp will have max j cuts

            if(isPal[0][j] == true){
                dp[j] = 0;
            }
            else{
                for(int i = j ; i> 0 ; i--){
                    if(isPal[i][j] == true){
                        dp[j] = Math.min(dp[j] , dp[i-1]  + 1);
                    }
                }
            }
        }

        return dp[dp.length-1];
    }
}