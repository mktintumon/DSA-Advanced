class splitArrLargestSum {

    public int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE;  // lowest sum allowed
        int high = 0; // highest sum allowed
        
        for(int val : nums){
            low = Math.max(low , val);
            high += val;
        }
        
        while(low < high){
           int mid = (low + high) / 2; // allowed limit for partition
            
            int countParts = 1;
            int partSum = 0;
            for(int val : nums){
                if(partSum + val <= mid){
                    //partSum + val <= limit  --> allowed
                    partSum += val;
                }
                else{
                    // limit se bahar chala gya -> break
                    partSum = val;
                    countParts++;
                }
            }
            
            if(countParts > m){
                // mtlab limit ko increase krna hoga -> for decreasing partition
                // limit ke niche wala sara value -> jyada partitions hi dega
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
    }
}
