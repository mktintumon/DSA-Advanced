import java.util.*;

class busRoutes {
    class Pair{
        int bus;
        int count;
        
        Pair(int bus , int count){
            this.bus = bus;
            this.count = count;
        }
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        
        // making hashmap of <stop , <buses>>
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        for(int bus=0 ; bus<routes.length ; bus++){
            for(int stop : routes[bus]){
                if(map.containsKey(stop) == false){
                    map.put(stop , new ArrayList<>());
                }
                
                map.get(stop).add(bus);
            }
        }
        
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        for(int bus : map.get(source)){
            qu.add(new Pair(bus , 1));
        }
        
        boolean[] visited = new boolean[routes.length];
        while(qu.size() > 0){
            // remove --> mark --> work --> add neighbour
            Pair rem = qu.remove();
            
            if(visited[rem.bus] == true) continue;
            
            visited[rem.bus] = true;
            
            //work
            for(int stop : routes[rem.bus]){
               if(stop == target){
                   return rem.count;
               }
            }
            
            // select stops  of removed bus one by one
            // search in hashmap
            for(int stop : routes[rem.bus]){
               for(int nbrBus : map.get(stop)){
                   if(visited[nbrBus] == false){
                       qu.add(new Pair(nbrBus , rem.count+1));
                   }
               } 
            }
        }
        
        return -1;
    }
}