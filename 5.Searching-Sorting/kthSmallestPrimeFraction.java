class kthSmallestPrimeFraction {

    public int[] kth_SmallestPrimeFraction(int[] arr, int k) {
        double low = 0.0;
        double high = 1.0;
        
        while(low < high){
            double mid = (low + high) / 2;
            
            // for returning ans
            int p = 0;
            int q = 1;
            
            int count = 0;
            int j = 0;
            for(int i=0 ; i<arr.length ; i++){
                while(j < arr.length && arr[i] * 1.0 > mid * arr[j] ){
                   j++;
                }

                if(j == arr.length) break;

                count += (arr.length - j);
                
                // taking nearest possible ans 
                if(p * arr[j] < q * arr[i]){
                    // (arr[i] / arr[j] > p / q)
                    p = arr[i];
                    q = arr[j];
                }
            }
            
            if(count < k){
                low = mid;
            } 
            else if(count > k){
                high = mid;
            } 
            else {
                return new int[]{p, q};
            }
        }
        
        return null;
    }
}