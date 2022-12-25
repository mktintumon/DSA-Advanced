
class bestTimeToBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) return 0;

        int[][] dp = new int[k+1][prices.length];
        for(int i=1 ; i<= k ; i++){
            int maxP = Integer.MIN_VALUE;
            for(int j=1 ; j<prices.length ; j++){
                maxP = Math.max(maxP , dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(maxP + prices[j] , dp[i][j-1]);
            }
        }

        return dp[k][prices.length-1];
    }
}
