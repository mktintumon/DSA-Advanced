class maxSwap_LC670 {

    public int maximumSwap(int num) {
        String str = num + "";
        char[] arr = str.toCharArray();
        
        // storing index -> as we need to swap
        int[] maxRight = new int[arr.length];
        
        for(int i=arr.length-1 ; i>=0 ; i--){
            if(i == arr.length-1){
                maxRight[i] = -1;
            }
            else if(i == arr.length-2){
                maxRight[i] = arr.length-1;
            }
            else{
                if(arr[i+1] > arr[maxRight[i+1]] ){
                    maxRight[i] = i+1;
                }
                else{
                    maxRight[i] = maxRight[i+1];
                }
            }
        }
        
        // last cell has idx -> -1 ... so travel till n-2
        for(int i=0 ; i<arr.length-1 ; i++){
            if(arr[i] < arr[maxRight[i]]){
                //swap
                char temp = arr[i];
                arr[i] = arr[maxRight[i]];
                arr[maxRight[i]] = temp;
                break;
            }
        }
        
        return Integer.parseInt(new String(arr));
    }
}
