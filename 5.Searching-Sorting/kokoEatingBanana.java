class kokoEatingBanana {
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int val : piles){
            high = Math.max(high , val);
        }
        
        while(low < high){
            int limit = (low + high) / 2;
            
            int totalSum = 0;
            for(int val : piles){
               int currSum = (val + limit - 1) / limit;  // ceil
               totalSum += currSum;
            }
            
            if(totalSum > h){
                low = limit + 1;
            }
            else{
                high = limit;
            }
        }
        
        return low; 
    }
}
