import java.util.*;

class nextPermutation {
    public void next_Permutation(int[] nums) {
        int i = nums.length-1;
        while(i > 0){
            if(nums[i-1] >= nums[i]) i--;
            else break;
        }
        
        if(i == 0){
            Arrays.sort(nums);
            return;
        }
        
        int num1 = i - 1;
        
        int j = nums.length-1;
        while(j > num1){
            if(nums[j] > nums[num1]) break;
            
            j--;
        }
        
        int num2 = j;
        
        swap(nums, num1 , num2);
        
        int left = num1 + 1;
        int right = nums.length-1;
        while(left < right){
            swap(nums , left , right);
            left++;
            right--;
        }
    }
    
    void swap(int[] arr , int x , int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}