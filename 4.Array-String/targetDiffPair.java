import java.util.*;

class targetDiffPair{
    public boolean findPair(int arr[], int size, int n){
        // n == target
        if(arr.length == 1) return false;

        Arrays.sort(arr);
        
        int i=0;
        int j=1;
        while(j < arr.length){
            if(arr[j] - arr[i] == n){
                return true;
            }
            else if(arr[j] - arr[i] < n){
                j++;
            }
            else{
                //arr[j] - arr[i] > n
                i++;
                if(i == j){
                    j++;
                }
            }
        }
        
        return false;
    }
}