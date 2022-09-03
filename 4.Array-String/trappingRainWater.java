class trappingRainWater {
    /*
       Logic --> hum idx pr khada ho kr dekhenge
                 ki left side se max kaun h aur right 
                 side se max kaun h
             --> phir left ka max aur right ka max se min le lenge
                 aur usse apna idx wala height minus kr denge ...   
    */

    public int trap(int[] height) {
        int n = height.length;
        
        int[] leftMax = new int[n];
        for(int i=0 ; i<n ; i++){
            if(i == 0){
                leftMax[i] = height[i];
            }
            else{
                leftMax[i] = Math.max(height[i] , leftMax[i-1]);
            }
        }
        
        int[] rightMax = new int[n];
        for(int i=n-1 ; i>=0 ; i--){
            if(i == n-1){
                rightMax[i] = height[i];
            }
            else{
                rightMax[i] = Math.max(height[i] , rightMax[i+1]);
            }
        }
        
        int totalWater = 0;
        for(int i=0 ; i<n ; i++){
            int min =  Math.min(leftMax[i] , rightMax[i]);
            totalWater += min - height[i];
        }
        
        return totalWater;
    }
}
