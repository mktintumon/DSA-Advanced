public class bestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prevLeast = prices[0];
        
        for(int i=1 ; i<prices.length ; i++){
            prevLeast = Math.min(prevLeast , prices[i]);
            profit = Math.max(profit , prices[i] - prevLeast);
        }
        
        return profit;
    }
}

