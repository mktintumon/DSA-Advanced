public class bestTimeToBuySellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy_date = 0;
        int sell_date = 0;
        
        for(int i=1 ; i<prices.length ; i++){
            if(prices[i] > prices[i-1]){
                sell_date++;
            }
            else{
                // settle the transaction and start new transaction
                profit += (prices[sell_date] - prices[buy_date]);
                buy_date = sell_date = i;
            }
        }
        
        // if prices only increases
        profit += (prices[sell_date] - prices[buy_date]);
        
        return profit;
    }
}

