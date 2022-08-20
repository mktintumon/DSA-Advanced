import java.util.*;

class cheapestFlight_K_stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        // initialize array
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[src] = 0;
        
        //loop for k+1 times
        for(int i=0 ; i<k+1 ; i++){
            int[] currDist = distance.clone();
            
            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                
                // check for u in distance[]
                // update v in currDist[]
                if(distance[u] != Integer.MAX_VALUE){
                    currDist[v] = Math.min(currDist[v] , distance[u] + price);
                }
            }
            
            // updating d0 with current
            distance = currDist;
        }
        
        if(distance[dst] != Integer.MAX_VALUE){
            return distance[dst];
        } else {
            return -1;
        }
    }
}