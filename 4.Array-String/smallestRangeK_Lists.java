import java.util.*;

// ******************** SIMILAR TO MERGE K SORTED LIST *******************
/*
       # Merge K sorted list 
                 --> while(pq.size() > 0)
      

       # This Question        
                 --> while(pq.size() == nums.size())
                 --> Means if any of the list become exhausted , we break
                 --> har list se ek na ek banda PQ me available hona chaiye
*/

class smallestRangeK_Lists {

    class Pair implements Comparable<Pair>{
        int list;
        int idx;
        int val;
        
        Pair(int list , int idx , int val){
            this.list = list;
            this.idx = idx;
            this.val = val;
        }
        
        public int compareTo(Pair other){
           return this.val - other.val;
       }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        // while inserting element in PQ , we calculate max
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<nums.size() ; i++){
            Pair p = new Pair(i , 0 , nums.get(i).get(0));
            pq.add(p);
            max = Math.max(max , nums.get(i).get(0));
        }
        
        int start = 0;
        int end = 0;
        int size = Integer.MAX_VALUE; // finding smallest range
        
        while(pq.size() == nums.size()){
            Pair rem = pq.remove();
            int currSize = max - rem.val;
            
            // remove krte waqt range update krte jao
            if(currSize < size){
                size = currSize;
                start = rem.val;
                end = max;
            }
            
            // jis list se nikale h ..usi list ka next banda dalenge
            int newList = rem.list;
            int newIdx = rem.idx + 1;
            if(newIdx < nums.get(newList).size()){
                int newVal = nums.get(newList).get(newIdx);
                
                pq.add(new Pair(newList , newIdx , newVal));
                // dalte waqt max update
                max = Math.max(max , newVal);
            }
        }
        
        return new int[]{start , end};
    }
}
