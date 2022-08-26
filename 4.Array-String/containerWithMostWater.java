class containerWithMostWater {

   // TC -> O(n)

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        
        while(left < right){
            int base = right - left;
            int area = Math.min(height[left] , height[right]) * base;
            ans = Math.max(ans , area);
            
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return ans;
    }
}