class partitionDisjointInterval {
    /*
    APPROACH-1  --> taking extra space 
                --> find max from left and min from right
                --> if left side ka max Right side ke min se chota ho
                --> return size --> i+1 --> 0 based indexing

    APPROACH-2 --> O(1) space and O(n) time complexity        

    */
    public int partitionDisjoint_1(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        
        //leftMax
        for(int i=0 ; i<nums.length ; i++){
            if(i == 0){
                leftMax[i] = nums[i];
            }
            else{
                leftMax[i] = Math.max(nums[i] , leftMax[i-1]);
            }
        }
        
        //rightMin --> filling reversely
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(i == nums.length-1){
                rightMin[i] = nums[i];
            }
            else{
                rightMin[i] = Math.min(nums[i] , rightMin[i+1]);
            }
        }
        
        int ans = -1;
        for(int i=0 ; i<nums.length-1 ; i++){
            if(leftMax[i] <= rightMin[i+1]){
                ans =  i+1;
                break;
            }
        }
        
        return ans;
    }

    public int partitionDisjoint_2(int[] nums) {
        int pi = 0;        // partition index
        int mtp = nums[0]; // max till partition
        int mtt = nums[0]; // max till travel
        
        for(int i=1 ; i<nums.length ; i++){
            mtt = Math.max(mtt , nums[i]);
            
            //Each element in left is <= every element in right.
            if(nums[i] < mtp){
                pi = i;
                mtp = mtt;
            }
        }
        
        return pi + 1; // length
    }
}