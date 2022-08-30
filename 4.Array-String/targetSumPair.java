import java.util.*;

class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x){
        Arrays.sort(arr);
        
        int l = 0;
        int r = arr.length - 1;
        
        while(l < r){
            if(arr[l] + arr[r] < x){
                l++;
            } else if(arr[l] + arr[r] > x){
                r--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}