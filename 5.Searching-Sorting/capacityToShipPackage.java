class capacityToShipPackage {
    
    public int shipWithinDays(int[] weights, int days) {
        
        // same code as LC - 410
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int wt : weights){
            low = Math.max(low , wt);
            high += wt;
        }
        
        while(low < high){
            int limit = (low + high) / 2;
            
            int countDays = 1;
            int weightSum = 0;
            for(int wt : weights){
                if(weightSum + wt <= limit){
                    weightSum += wt;
                }
                else{
                    weightSum = wt;
                    countDays++;
                }
            }
            
            if(countDays > days){
               low = limit + 1;
            }
            else{
                high = limit;
            }
        }
        
        return low;
    }
}