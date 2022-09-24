import java.util.*;

// MEETING ROOM 2 -> same code

// find max no. of trains at a platform at particular time
class minPlatforms{
    
    static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int count = 0;
        int max = 0;
        
        int i = 0;
        int j = 0;
        while(i < arr.length && j < dep.length ){
            if(arr[i] <= dep[j]){
                i++;
                count++;
            }else{
               //arr[i] > dep[j]
               j++;
               count--;
            }
            
            max = Math.max(count , max);
        }
        
        return max;
    }
    
}
