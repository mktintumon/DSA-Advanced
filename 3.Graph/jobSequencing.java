import java.util.*;

class jobSequencing{
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z; 
        }
    }

    
    int[] parent;
    
    int[] JobScheduling(Job arr[], int n){
        // sorting on basis of max to min profit
         Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });
        
        parent = new int[101];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        int jobCount = 0;
        int totalProfit = 0;
        
        for(Job j : arr){
            // max profit job done on last day of deadline
            int emptySlot = find(j.deadline);
            
            // if slots not available we will leave the remaining jobs
            if(emptySlot > 0){
                jobCount++;
                totalProfit += j.profit;
                
                // making union
                parent[emptySlot] = find(emptySlot - 1);
            }
        }
        
        return new int[]{jobCount , totalProfit};
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}
