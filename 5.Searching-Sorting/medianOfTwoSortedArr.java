class medianOfTwoSortedArr {

    // binary search technique --> log(m+n)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // start binary search in smaller one
        if(m > n){
            return findMedianSortedArrays(nums2 , nums1);
        }
        
        int low = 0;
        int high = m;
        int medianPos = (m + n + 1) / 2;
        
        while(low <= high){
            int part1 = (low + high) / 2;
            int part2 = medianPos - part1;
            
            int left1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int left2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int right1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];
            int right2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];
            
            // three cases
            if(left1 <= right2 && left2 <= right1){
                if((m + n) % 2 == 0){
                    //even
                    return ( Math.max(left1 , left2) + Math.min(right1 , right2) ) / 2.0;
                }
                else{
                    //odd
                     return Math.max(left1 ,left2);
                }
            }
            else if(left1 > right2){
                high = part1 - 1;
            }
            else{
                // left2 > right1
                low = part1 + 1;
            }
                
        }
        
        return 0.0;
    }
}