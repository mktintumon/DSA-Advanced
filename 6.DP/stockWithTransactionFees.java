public class stockWithTransactionFees {
    public int maxProfit(int[] prices, int fee) {
        int old_bsp = -prices[0];
        int old_ssp = 0;
        
        for(int i=0 ; i<prices.length ; i++){
            int new_bsp = Math.max(old_ssp - prices[i]  , old_bsp);
            int new_ssp = Math.max(old_bsp + prices[i] - fee  , old_ssp);   
            
            old_bsp = new_bsp;
            old_ssp = new_ssp;
        }
        
        return old_ssp;
    } 
}

