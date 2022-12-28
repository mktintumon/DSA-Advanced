
class optimalBST{
    
    static int optimalSearchTree(int keys[], int freq[], int n){
        int[][] dp = new int[keys.length][keys.length];
        
        // getting sum of frequency at each level needed
        int[] prefixSum = new int[freq.length];
        prefixSum[0] = freq[0];
        for(int i=1 ; i<keys.length ; i++){
            prefixSum[i] = freq[i] + prefixSum[i-1];
        }
        
        for(int gap = 0 ; gap < dp[0].length ; gap++ ){
            for(int i = 0 , j = gap ; j < dp[0].length ; i++ , j++ ){
                if(gap == 0){
                    dp[i][j] = freq[i];
                }
                else if(gap == 1){
                    dp[i][j] = Math.min(1*freq[i]+2*freq[j] , 2*freq[i]+1*freq[j]);
                }
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    // k2 start with gap+1 instead of gap bcoz we want 
                    // to cover blank(-1) cell index also
                    for(int k1=1 , k2=gap+1 ; k2>=1 ; k1++ , k2--){
                        int left = (j-k2) == -1 ? 0 : dp[i][j-k2];
                        int right = (i+k1) == dp.length ? 0 : dp[i+k1][j];
                        int joinFactor = prefixSum[j] - ( (i>0) ? prefixSum[i-1] : 0);
                        
                        dp[i][j] = Math.min(dp[i][j] , left+right+joinFactor);
                    }
                }
            }
        }
        
        return dp[0][dp[0].length-1];
    }
}