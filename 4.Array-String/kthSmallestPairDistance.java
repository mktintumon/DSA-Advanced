import java.util.*;

class kthSmallestPairDistance {

    // Pattern Question
    // only diffrence is we start pointer from 0 , not from n-1
    // little difficult to find pattern

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int low = 0;
        int high = nums[n-1] - nums[0];
        for(int i=0 ; i<n-1 ; i++){
            low = Math.min(low , nums[i+1] - nums[i]);
        }
        
        while(low < high){
            int mid = low + (high - low) / 2;
            
            int count = 0;
            int j = 0;
            for(int i=0 ; i<n ; i++){
                while(j < n && (nums[j] - nums[i] <= mid)){
                    j++;
                }
                
                count += (j - i - 1);
            }
            
            if(count < k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
    }
}
