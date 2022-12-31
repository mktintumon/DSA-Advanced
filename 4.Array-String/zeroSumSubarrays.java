import java.util.*;

class zeroSumSubarrays{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(sum , 1);
        
        for(int i=1 ; i<=n ; i++){
            sum += arr[i-1];
            map.put(sum , map.getOrDefault(sum,0)+1 );
            ans += map.get(sum) - 1;
        }
        return (long)ans;
    }
}
