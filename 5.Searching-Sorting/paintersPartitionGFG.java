class paintersPartitionGFG {
    
    static long minTime(int[] arr,int n,int k){
        long lowTime = Long.MIN_VALUE;
        long highTime = 0;
        for(int val : arr){
            lowTime = Math.max(lowTime , val);
            highTime += val;
        }
        
        while(lowTime < highTime){
            Long limitTime = (lowTime + highTime) / 2;
            
            int totalPartitions = 1;
            int currTimeSum = 0;
            for(int val : arr){
                if(currTimeSum + val <= limitTime){
                    currTimeSum += val;
                }
                else{
                    totalPartitions++;
                    currTimeSum = val;
                }
            }
            
            if(totalPartitions > k){
                lowTime = limitTime + 1;
            }
            else{
                highTime = limitTime;
            }
        }
        
        return lowTime;
    }
}
