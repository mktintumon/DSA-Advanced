import java.util.*;

class leastGreaterElementRight {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int val : arr){
            tm.put(val , tm.getOrDefault(val,0)+1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : arr){
            int count = tm.get(val);
            
            if(count > 1){
                tm.put(val , count-1);
            }
            else{
                tm.remove(val);
            }
            
            // new concept
            Integer ceil = tm.ceilingKey(val + 1);
            if(ceil != null){
                ans.add(ceil);
            }
            else{
                ans.add(-1);
            }
        }
        
        return ans;
    }
}