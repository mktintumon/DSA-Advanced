class minEleRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low < high){
            int mid = (low + high) / 2;
            
            // left area -> 0 to mid
            // right area -> mid+1 to high    
            
            if(nums[high] > nums[mid]){
                // min will be in mid of left side area 
                high = mid;
            }
            else{
                // nums[high] < nums[mid]
                // min will be in mid of right side area
                low = mid + 1;
            }
        }
        
        return nums[high]; // or return nums[low];
    }
}