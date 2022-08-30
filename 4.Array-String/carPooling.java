import java.util.*;

class carPooling {
    // We can use AL but we have to sort it at last
    // TreeSet --> contains in sorted order --> unique
    // TreeSet time complexity --> O(logn)
    // GIVEN --> 0 <= fromi < toi <= 1000
    
    public boolean car_Pooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        TreeSet<Integer> stops = new TreeSet<>();
        
        for(int[] trip : trips){
            int people = trip[0];
            int src = trip[1];
            int dest = trip[2];
            
            // boarding in
            map[src] += people;
            stops.add(src);
            
            //boarding out
            map[dest] -= people;
            stops.add(dest);
        }
        
        int cap = 0;
        for(int stop : stops){
            int val = map[stop];
            cap += val;
            
            if(cap > capacity) return false;
        }
        
        return true;
    }
}
