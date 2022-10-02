import java.util.*;

class longestIncreasingSubSeq {

    // O(n^2) APPROACH
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for(int i=1 ; i<dp.length ; i++){
            int max = 0;
            
            for(int j=0 ; j<i ; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max , dp[j]);
                }
            }
            
            dp[i] = max + 1;
        }
        
        int len = 0;
        for(int val : dp){
            len = Math.max(len , val);
        }
        
        return len;
    }

    // O(nlogn) -> loop -> binary search
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 1;
        tails[0] = nums[0];
        
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] > tails[len-1]){
                len++;
                tails[len-1] = nums[i];
            }
            else{
                int idx = Arrays.binarySearch(tails , 0 ,len-1 , nums[i]);
                if(idx < 0){
                    idx = -idx;
                    idx = idx -1;
                }
                
                tails[idx] = nums[i];
            }
        }
        
        return len;
    }
}
