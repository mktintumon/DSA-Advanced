class kthSmallestMultiplicationTable {

    // same code as -> kthSmallestSortedMatrix
    // only diference -> 1 based indexing

    public int findKthNumber(int m, int n, int k) {
        
        int low = 1;
        int high = m * n;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            
            int count = 0;
            int j = n;
            for(int i=1 ; i <= m ; i++){
                while(j >= 0 && i * j > mid){
                    j--;
                }
                
                count += j;
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
