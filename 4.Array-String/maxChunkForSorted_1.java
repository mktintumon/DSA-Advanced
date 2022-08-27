class maxChunksForSorted_1 {

    // TC -> O(n) and SC -> O(1)
    // arr[n] -> values -> 0 to n-1

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = arr[0];
        
        for(int i=0 ; i<arr.length ; i++){
            max = Math.max(max , arr[i]);
            
            if(max == i) count++;
        }
        
        return count;
    }
}