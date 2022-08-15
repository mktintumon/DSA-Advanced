import java.util.*;

class Solution{


    /*
    
    # if degree count of 2 vertex is odd -> euler path
    # if degree count of every vertex is even -> euler circuit

    */

    public int eulerPathAndCircuit(int V, ArrayList<ArrayList<Integer>> adj){
        int count = 0;
        for(int i=0 ; i<V ; i++){
            if(adj.get(i).size() % 2 == 1){
                count++;
            }
        }
        
        if(count == 2){
            // euler path
            return 1;
        }
        else if(count == 0){
            // euler circuit
            return 2;
        }
        else{
            // none
            return 0;
        }
    }
}

/*   SAME APPROACH AS ABOVE (but in terms of grid[][])

class Solution{
    static int eulerPath(int N, int graph[][]){
       int count = 0;
       
       for(int i=0 ; i<graph.length ; i++){
           int size = 0;
           for(int j=0 ; j<graph.length ; j++){
               if(i != j && graph[i][j] == 1){
                   size++;
               }
           }
           
           //check for odd degree of vertex
           if(size % 2 == 1){
               count++;
           }
       }
       
       // if degree count of 2 vertex is odd -> euler path
       if(count == 0 || count == 2){
           return 1;
       }
       else{
           return 0;
       }
    }
}
*/