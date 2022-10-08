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

    // our own binary search implementation
    // used in the O(nlogn) approach
    // if found gives the index of value
    // if not found gives the idx,where to be inserted with -ve sign 
    public int binarySearch(int[] arr, int lo, int hi, int val) {
		int ans = -1;
		int ans2 = -1;
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(val == arr[mid]) {
				ans = mid;
				lo = mid + 1;
			} else if(val < arr[mid]) {
				hi = mid - 1;
				ans2 = -(hi + 2);
			} else {
				lo = mid + 1;
				ans2 = -(lo + 1);
			}
		}
		
		if(ans == -1) {
			ans = ans2;
		} 
		
		return ans;
	}
}
