import java.util.*;

class weightedJobSchedule2 {

    // O(n^2) --> TIME LIMIT EXCEEDED
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // combining 3 arrays into one
        int[][] arr = new int[startTime.length][3];
        for(int i=0 ; i<startTime.length ; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        
        Arrays.sort(arr , (a,b)->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else{
                return a[1] - b[1];
            }
        });
        
        int[] lis = new int[arr.length];
        lis[0] = arr[0][2]; // doing first job is mandatory
        
        for(int i=1 ; i<lis.length ; i++){
            int max = 0;
            for(int j=0 ; j<i ; j++){
               if(arr[j][1] <= arr[i][0]){
                   max = Math.max(max , lis[j]);
               } 
            }
            
            lis[i] = max + arr[i][2];
        }
        
        int len = 0;
	    for(int val: lis){
	        len = Math.max(len, val);
	    }
	    
	    return len;
    }

    
}
