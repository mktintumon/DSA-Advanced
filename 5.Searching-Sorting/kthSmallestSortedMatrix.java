class kthSmallestSortedMatrix {
    
    // we can also solve it using PQ (simple)
    // In below method we save space

    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        
        while(low < high){
            int mid = low + (high - low) / 2;
            
            int count = 0;
            int j = matrix.length-1;
            for(int i=0 ; i<matrix.length ; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                
                count += (j+1);
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