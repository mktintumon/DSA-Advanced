import java.util.*;

// APPROACH - 1 --> USING STACK
// APPROACH - 2 --> USING AL as STACK

class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> {
            return a[0] - b[0];
        });
        
        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] curr : intervals){
            if(ans.size() == 0){
                ans.add(curr);
            }
            else{
                int[] prev = ans.get(ans.size()-1);
                
                if(curr[0] > prev[1]){
                    // sahi ja rha h -> just add
                    ans.add(curr);
                }
                else{
                    // gadbad h --> curr[0] <= prev[1]
                    prev[1] = Math.max(prev[1] , curr[1]);
                }
            }
        }
        
        // AL to int[][] conversion
        return ans.toArray(new int[ans.size()][2]); 
    }
}