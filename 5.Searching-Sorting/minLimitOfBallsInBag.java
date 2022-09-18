class minLimitOfBallsInBag {

    // complex to understand -> difficult to figure out binary pattern

    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        for(int val : nums){
            high = Math.max(high , val);
        }
        
        while(low < high){
            int limit = (low + high) / 2;
            
            int reqOps = 0;
            for(int val : nums){
                if(val > limit){
                    int leftVal = val - limit;
                    int operations = (leftVal + limit - 1) / limit; // ceil
                    reqOps += operations;
                }
            }
            
            if(reqOps > maxOperations){
                low = limit + 1;
            }
            else{
                high = limit;
            }
        }
        
         return low;
    }
}
