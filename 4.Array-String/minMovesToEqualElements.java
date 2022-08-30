class minMovesToEqualElements {

   // Given --> In one move,you can increment n - 1 elements of the array by 1.

   // Trick --> In one move , we decrease one element by 1. (reverse)

    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int val : nums){
            min = Math.min(min , val);
        }
        
        int count = 0;
        for(int val : nums){
            count += val - min;
        }
        
        return count;
    }
}