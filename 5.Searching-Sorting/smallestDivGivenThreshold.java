import java.util.*;
/*
    # we can  use high  = 1000000  
    # use binary bcoz
                --> if sum > threshold , that means we have to decrease
                    the sum . for which we need to increase the divisor
                    and vice versa.
    # GIVEN -> we need to consider the ceil while division -> (val + mid - 1) / mid;              
*/
class SolutismallestDivGivenThresholdon {
    
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        //int high = max element in array
        int high = Arrays.stream(nums).max().getAsInt(); // O(n) -> inbuilt
        
        while(low < high){
            int mid = (low + high) / 2;
            
            int sum = 0;
            for(int val : nums){
               int quotient = (val + mid - 1) / mid; 
               sum += quotient;
            }
            
            if(sum > threshold){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
    }
}
