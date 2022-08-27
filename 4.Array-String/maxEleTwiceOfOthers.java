class maxEleTwiceOfOthers {

    // 747. Largest Number At Least Twice of Others

    /*
         BRUTE :- 
              --> travel and find maximum --> idx
              --> travel and skip max ele idx and check condition 
    */

    public int dominantIndex(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int idx = 0;
        
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] > firstMax){
                secondMax = firstMax;
                firstMax = nums[i]; 
                idx = i;
            }
            else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        
        if(secondMax * 2 <= firstMax) return idx;
        else return -1;
    }
}
