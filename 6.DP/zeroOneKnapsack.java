class zeroOneKnapsack { 

    // use 2D array -> Refer -- (target sum subset) -> just maximize cells
    static int knapSack(int W, int wt[], int val[], int n) { 
         int[][] dp = new int[n+1][W+1];
         
         for(int i=0 ; i<dp.length ; i++){
             for(int j=0 ; j<dp[0].length ; j++){
                 if(i == 0){
                     dp[i][j] = 0;
                 }
                 else if(j == 0){
                     dp[i][j] = 0;
                 }
                 else {
                     int currWt = wt[i-1];
                     
                     int exclude = dp[i-1][j];
                     int include = 0;
                     if(j - currWt >= 0){
                         include = dp[i-1][j-currWt] + val[i-1];
                     }
                     
                     dp[i][j] = Math.max(include , exclude);
                 }
             }
         }
         
         return dp[dp.length-1][dp[0].length-1];
    } 
}
