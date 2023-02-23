class jumpGame2 {
    
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }

        int count = 0;
        int curr = 0;
        while(curr < nums.length){
            if(curr + nums[curr] >= nums.length-1){
                count++;
                break;
            }

            int via = curr;
            for(int i=curr+1 ; i <= curr + nums[curr] && i < nums.length ; i++){
                if(i + nums[i] > via + nums[via]){
                    via = i;
                }
            }

            curr = via;
            count++;
        }

        return count;
    }
}