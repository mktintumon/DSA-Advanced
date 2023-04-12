import java.util.*;

class minCoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int tar=1 ; tar<dp.length ; tar++){
            for(int c=0 ; c<coins.length ; c++){
                if(tar >= coins[c] && dp[tar-coins[c]] != Integer.MAX_VALUE){
                    dp[tar] = Math.min(dp[tar] , 1+dp[tar-coins[c]]);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
