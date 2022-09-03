import java.util.*;
    
class insertIntervals {

    /*
        # let intervals[i]--> [a , b]  newInterval -->[c , d]
        # first loop consider b and c
        # second loop consider a and d
               --> interval = newInterval
               --> interval[0] = min(a , c)
               --> interval[1] = max(b , d)
        # third loop is freely moving
    */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        int i = 0;
        // finding spot where to insert new interval
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        
        int[] interval = newInterval;
        // keep merging intervals until becomes stable
        while(i < intervals.length && intervals[i][0] <= interval[1]){
            interval[0] = Math.min(intervals[i][0] , interval[0]);
            interval[1] = Math.max(intervals[i][1] , interval[1]);
            i++;
        }
        
        // become statble --> add to AL 
        ans.add(interval);
        
        // keep adding the rest elements
        while(i < intervals.length){
            ans.add(intervals[i]);
            i++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}    