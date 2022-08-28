import java.util.*;

// both approach is same --> manipulation of maths equations only 

class minMovesToEqualElements2 {

    // faster code
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length-1;
        int count = 0;
        while(left < right){
            count += nums[right] - nums[left];
            left++;
            right--;
        }
        
        return count;
    }

    // little slower code
    public int minMoves_2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        
        int count = 0;
        for(int i=0 ; i<nums.length ; i++){
            count += Math.abs(nums[mid] - nums[i]);  
        }
        
        return count;
    }
}