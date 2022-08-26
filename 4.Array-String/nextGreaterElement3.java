class nextGreaterElement3 {

    // same question -> LC-31 --> next permutation

    public int nextGreaterElement(int n) {
        // conversion int to char[]
        String str = n + "";
        char[] arr = str.toCharArray();
        
        int i = arr.length-1;
        while(i > 0){
            if(arr[i-1] >= arr[i]) i--;
            else break;
        }
        
        // no smaller available
        if(i == 0) return -1;
        
        int num1 = i-1;
        
        int j = arr.length-1;
        while(j > num1){
            if(arr[j] > arr[num1]) break;
            
            j--;
        }
        
        int num2 = j;
        
        //swap
        swap(arr , num1 , num2);
        
        // sort from idx -> num1+1 to arr.length-1
        int left = num1 + 1;
        int right = arr.length-1;
        while(left < right){
            swap(arr , left , right);
            left++;
            right--;
        }
        
        //conversion to int
        String ans = new String(arr);
        long val = Long.parseLong(ans);
        return (val > Integer.MAX_VALUE ? -1 : (int)val);
    }
    
    void swap(char[] arr , int x , int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}