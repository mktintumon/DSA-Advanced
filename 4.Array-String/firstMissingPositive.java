class firstMissingPositive {

    public int first_Missing_Positive(int[] nums) {
        int n = nums.length;
        
        // travel and replace --> making all positive
        for(int i=0 ; i<n ; i++){
           if(nums[i] <= 0 || nums[i] > n){
               nums[i] = n+1;
           } 
        }
        
        // makes elements negative as possible in range only
        for(int i=0 ; i<n ; i++){
            int val = Math.abs(nums[i]);
            
            if(val <= n){
                int idx = val - 1;
                
                if(nums[idx] > 0){
                    nums[idx] = -1 * nums[idx];
                }
            }
        }
        
        // first positive idx+1 will be ans
        for(int i=0 ; i<n ; i++){
           if(nums[i] > 0){
               return i + 1;
           } 
        }
        
        return n+1;
    }
}
