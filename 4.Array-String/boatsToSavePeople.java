import java.util.*;

//  1 <= people[i] <= limit <= 3 * 104

class boatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0;
        int left = 0;
        int right = people.length-1;
        
        while(left < right){
            // 2 people at a time
            int weight = people[left] + people[right];
            
            if(weight <= limit){
               //both will go in same boat
               count++;
               left++;
               right--; 
            }
            else{
                // now only one allowed -> which one allowed ? -> left or right one ?
                // right pointer person(bigger element) will go --> array is sorted
                count++;
                right--;
            }
        }
        
        // if one element left
        if(left == right) count++;
        
        return count;
    }
}
