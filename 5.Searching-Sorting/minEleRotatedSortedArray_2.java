class minEleRotatedSortedArray_2 {

    // contains duplicate elements

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            
            if(nums[high] > nums[mid]){
                high = mid;
            }
            else if(nums[high] < nums[mid]){
                low = mid + 1;
            }
            else{
                //equal
                // ultimately it convergers to low only 
                // so keep low as it is
                high--;
            }
        }
        
        return nums[low];
    }
}