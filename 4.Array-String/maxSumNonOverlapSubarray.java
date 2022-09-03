class maxSumNonOverlapSubarray {
    /*
        # Given --> len1 = 4 and len2 = 3

        # 4 loops working
                  ---> first loop --> leftSum len1
                  ---> second loop --> rightSum len2
                  ---> third loop --> leftSum len2
                  ---> fourth loop --> rightSum len1

        # for non overlapping subarrays we compare leftSum[i] with rightSum[i+1]
      
    */

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1 = getMax(nums , firstLen , secondLen);
        int max2 = getMax(nums , secondLen , firstLen);
        return Math.max(max1 , max2);
    }
    
    int getMax(int[] nums, int len1 , int len2){
        
        int[] leftSum = new int[nums.length];
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            
            if(i == len1-1){
                leftSum[i] = sum;
            }
            else if(i >= len1){
                sum -= nums[i - len1];
                leftSum[i] = Math.max(sum , leftSum[i-1]);
            }
        }
        
        int[] rightSum = new int[nums.length];
        sum = 0;
        for(int i=nums.length-1 ; i>=0 ; i--){
            sum += nums[i];
            
            if(i == nums.length - len2){
                rightSum[i] = sum;
            }
            else if(i < nums.length - len2){
                sum -= nums[i + len2];
                rightSum[i] = Math.max(sum , rightSum[i+1]);
            }
        }
        
        // for non over-lapping subarrays
        int max = Integer.MIN_VALUE;
        for(int i = len1-1; i < nums.length - len2 ; i++){
            max = Math.max(max, leftSum[i] + rightSum[i + 1]);
        }
        
        return max;
    }
}