class kadanesAlgo {

   /*  Max subArray sum

      LOGIC -> current idx element thinks and decides
               --> piche se sum -ve aa rha h ...apni train start kro
               --> piche se sum +ve aa rha h ...unhi ke saath jud jao
   */

    
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0 ; i<nums.length ; i++){
            if(sum < 0){
              sum = nums[i];  
            }
            else{
              sum += nums[i];  
            }
            
            maxSum = Math.max(maxSum , sum);
        }
        
        return maxSum;
    }
}
