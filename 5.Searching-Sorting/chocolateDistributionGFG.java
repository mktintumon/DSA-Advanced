import java.util.*;

class chocolateDistributionGFG{

    public long findMinDiff (ArrayList<Integer> a, int n, int m){
        Collections.sort(a);
        
        // sliding window --> window of m
        int min = Integer.MAX_VALUE;
        for(int end = m-1 ; end < a.size() ; end++){
            int start = end - m + 1;
            int diff = a.get(end) - a.get(start);
            min = Math.min(min , diff);
        }
        
        return min;
    }
}