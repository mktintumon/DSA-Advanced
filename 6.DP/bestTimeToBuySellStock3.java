class bestTimeToBuySellStock3 {
    
    public int maxProfit(int[] prices) {
        int[] dp_sell = new int[prices.length];
        dp_sell[0] = 0;
        int min = prices[0];
        
        for(int i=1 ; i<prices.length ; i++){
            min = Math.min(min , prices[i]);
            int profit = prices[i] - min;
            dp_sell[i] = Math.max(profit , dp_sell[i-1]);
        }
        
        int[] dp_buy = new int[prices.length];
        dp_buy[prices.length-1] = 0;
        int max = prices[prices.length-1];
        
        for(int i=prices.length-2 ; i>=0 ; i--){
            max = Math.max(max , prices[i]);
            int profit = max - prices[i];
            dp_buy[i] = Math.max(profit , dp_buy[i+1]);
        }
        
        int maxProfit = 0;
        for(int i=0 ; i<prices.length ; i++){
            maxProfit = Math.max(dp_sell[i]+dp_buy[i] , maxProfit);
        }
        
        return maxProfit;
    }
}
