class subarrayMaxBound {

    /*
    
     * Input: nums = [2,1,4,3], left = 2, right = 3
     * Output: 3
     * Explanation: There are three subarrays that meet the requirements: 
                    [2], [2,1], [3].
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1;
        int end = -1;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                end = i;
            } else if (nums[i] > right) {
                start = end = i;
            }

            // nums[i] < left ---> do nothing just proceed and add difference

            count += (end - start);
        }

        return count;
    }
}