import java.util.*;

// FASTER CODE IF WE MAKE GRAPH instead of using Array 

class courseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       
    /*  MAKING GRAPH

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[0]].add(edge[1]);
        }

    */    

        int[] topoSort = new int[numCourses];
        
        // make array contains indegree count
        int[] inDegree = new int[numCourses];
        for(int[] edge : prerequisites){
            inDegree[edge[1]]++;
        }
        
        // indgree with count 0 ->> add to queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int course = 0; course < numCourses; course++){
            if(inDegree[course] == 0){
                queue.add(course);
            }
        }
        
        
        // printing --> its reverse topoSort --> start idx from last
        
        int idx = topoSort.length-1;
        while(queue.size() > 0){
            // remove from queue 
            // print/add 
            // decrease indegree of nbr  
            // check for 0 indegree and add to queue
            
            int course = queue.remove();
            topoSort[idx] = course;
            idx--;
            
            for(int[] edge : prerequisites){
                if(edge[0] == course){
                    inDegree[edge[1]]--;
                
                    if(inDegree[edge[1]] == 0){
                        queue.add(edge[1]);
                    }
                }
            }
        }
        
        // cycle detected
        if(idx != -1){
            return new int[]{};
        }
        
        return topoSort;
    }
}
