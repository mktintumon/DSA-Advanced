import java.util.*;
/*
    *  adj: vector of vectors which represents the graph
    *  S: source vertex to start traversing graph with
    *  V: number of vertices
    *  1e8 == Integer.MAX_VALUE == 100000000
*/
class bellmanFordAlgo{

    // USING SINGLE ARRAY
    static int[] bellmanFord_SingleArray(int V, ArrayList<ArrayList<Integer>> adj, int S){
        int[] distance = new int[V];
        Arrays.fill(distance, 100000000);
        distance[S] = 0;
        
        for(int i = 1; i <= V - 1; i++){
            for(ArrayList<Integer> edge: adj){
                int u = edge.get(0);
                int v = edge.get(1);
                int p = edge.get(2);
                if(distance[u] == 100000000){
                    continue;
                } else if(distance[v] == 100000000){
                    distance[v] = distance[u] + p;
                } else {
                    // already some value present -> ladai me jo jeetega wahi aayega
                    distance[v] = Math.min(distance[v], distance[u] + p);
                }
            }
        }
        
        return distance;
    }
    
    // USING TWO ARRAYS
    static int[] bellmanFord_2Array(int V, ArrayList<ArrayList<Integer>> adj, int S){
        int[] distance = new int[V];
        Arrays.fill(distance, 100000000);
        distance[S] = 0;
        
        for(int i=0 ; i<= V-1 ; i++){
            int[] currDist = distance.clone();

            for(ArrayList<Integer> edge: adj){
                int u = edge.get(0);
                int v = edge.get(1);
                int price = edge.get(2);
                
                if(distance[u] != 100000000){
                    currDist[v] = Math.min(currDist[v] , distance[u] + price);
                }
            }
            
            //updating
            distance = currDist;
        }
        
        return distance;
    }
}

