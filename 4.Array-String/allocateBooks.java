import java.util.*;

public class allocateBooks {

    public int books(ArrayList<Integer> A, int B) {
        if(A.size() < B){
            return -1;
        }
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int val : A){
            low = Math.max(low , val);
            high += val;
        }
        
        while(low < high){
            int limit = (low + high) / 2;
            
            int allocations = 1;
            int allocateSum = 0;
            for(int val : A){
                if(allocateSum + val <= limit){
                    allocateSum += val; 
                }
                else{
                    allocations++;
                    allocateSum = val;
                }
            }
            
            if(allocations > B){
                low = limit + 1;
            }
            else{
                high = limit;
            }
        }
        
        return low;
    }
}
