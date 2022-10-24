class unboundedKnapsack{

    //Knapsack with Duplicate Items
    
    static int knapSack(int N, int W, int val[], int wt[]){
        int[] dp = new int[W+1];
        for(int tar=0 ; tar<dp.length ; tar++){
            int max = 0;
            // give chance to every element of array
            for(int i=0 ; i<wt.length ; i++){
                if(tar - wt[i] >= 0){
                    int optimal = val[i] + dp[tar - wt[i]];
                    if(optimal > max){
                        max = optimal;
                    }
                }
            }
            
            dp[tar] = max;
        }
        
        return dp[dp.length-1];
    }
}
