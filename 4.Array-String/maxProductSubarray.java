class maxProductSubarray {

    /* 
    --> break the flow if we found product become zero
    
    --> If we use kadanes Algo then we have to break  
        if we got negative product ... BUT this will lead 
        us to wrong approach side
        BCOZ --> -ve product may become +ve after multiply with -ve number
      
    */

    public int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        
        //product from prefix
        int prod = 1;
        for(int i=0 ; i<nums.length ; i++){
            prod *= nums[i];
            
            maxProd = Math.max(prod , maxProd);
            
            if(prod == 0) prod = 1;
        }
        
        // product from suffix
        prod = 1;
        for(int i=nums.length-1 ; i>=0 ; i--){
            prod *= nums[i];
            
            maxProd = Math.max(prod , maxProd);
            
            if(prod == 0) prod = 1;
        }
        
        return maxProd;
    }
}
