class mergeSortGFG{

    void merge(int arr[], int l, int m, int r){
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        
        for (int i = 0; i < left.length ; i++){
            left[i] = arr[l + i];
        }
            
        for (int i = 0 ; i < right.length ; i++){
            right[i] = arr[m + 1 + i];
        }
        
        int i = 0;
        int j = 0;
        int k = l; // not start k = 0 --> in-place array sorting
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        while(i < left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        
        while(j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    
    void mergeSort(int arr[], int l, int r){
        if(l < r){
            int mid =l+ (r-l)/2;
            
            mergeSort(arr , l , mid);
            mergeSort(arr , mid+1 , r);
            
            merge(arr , l , mid , r);
        }
    }
}

