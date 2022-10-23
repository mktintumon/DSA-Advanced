class coinChange {

    public int combination(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int coin : coins){
            for(int tar=1 ; tar<=amount ; tar++){
                if(tar >= coin){
                    dp[tar] += dp[tar - coin];
                }
            } 
        }
        
        return dp[amount];
    }

    public int permutation(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int tar=1 ; tar<=amount ; tar++){
            for(int coin : coins){
                if(tar >= coin){
                    dp[tar] += dp[tar - coin];
                }
            } 
        }
        
        return dp[amount];
    }
}
