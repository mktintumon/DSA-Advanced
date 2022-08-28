class maxDistanceToClosest {
    
    /*
        divide into 3 parts ->
            1. before first 1
            2. between two 1
            3. after last 1   
    */
    
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int count = 0;
        
        for(int i=0 ; i<seats.length ; i++){
            if(seats[i] == 1){
                int currCount = 0;
                
                if(prev < 0){
                    // --> 000000100100
                    currCount = i;
                }
                else{
                    // --> 1000001
                    currCount = (i - prev) / 2;
                }
                
                count = Math.max(count , currCount);
                prev = i;
            }
        }
        
        // handles --> 1001001000000
        int currCount = seats.length - 1 - prev;
        count = Math.max(count , currCount);
        
        return count;
    }
}