import java.util.*;

public class buildingBridges {

    public static int maxNonOverlappingBridges(int[][] arr){
        // sort north coordinates
        Arrays.sort(arr, (b1, b2) -> {
	        if(b1[0] != b2[0]){
	            return b1[0] - b2[0];
	        } else {
	            return b1[1] - b2[1];
	        }
	    });

        // apply LIS on the south coordinates
        int[] lis = new int[arr.length];
        lis[0] = 1;

        for(int i = 1; i < lis.length; i++){
            int max = 0;
            for(int j=0 ; j<i ; j++){
                if(arr[j][1] <= arr[i][1]){
	                max = Math.max(max, lis[j]);
	            }
            }

            lis[i] = max + 1;
        }

        int len = 0;
	    for(int val: lis){
	        len = Math.max(len, val);
	    }
	    
	    return len;
    }

    public static void main(String[] args) {
        int[][] arr = {{8, 1}, {1, 2}, {4, 3}, {3, 4}, {5, 5}, {2, 6}, {6, 7}, {7, 8}};
	
		System.out.println(maxNonOverlappingBridges(arr));
    }
}
