class stockWithCooldown {
     
    public int maxProfit(int[] prices) {
        int old_bsp = -prices[0];
        int old_ssp = 0;
        int old_cd = 0;
        
        for(int i=0 ; i<prices.length ; i++){
            int new_bsp = Math.max(old_cd - prices[i] , old_bsp);
            int new_ssp = Math.max(old_bsp + prices[i] , old_ssp); 
            int new_cd = Math.max(old_cd , old_ssp);
            
            old_bsp = new_bsp;
            old_ssp = new_ssp;
            old_cd = new_cd;
        }
        
        return old_ssp; 
    }
}
