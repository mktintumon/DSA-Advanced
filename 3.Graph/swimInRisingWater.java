import java.util.PriorityQueue;

class swimInRisingWater {
    class Pair{
        int i;
        int j;
        int time;
        
        Pair(int i , int j , int time){
           this.i = i;
           this.j = j;
           this.time = time; 
        }
    }
    
    public int swimInWater(int[][] grid) {
       boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        // uses lambda instead of comparable 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.time - b.time;
        }); 
        
        pq.add(new Pair(0 , 0 , grid[0][0]));
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1){
                return rem.time;
            }
            
            addNeighbours(rem.i - 1, rem.j, rem.time, grid, visited, pq);
            addNeighbours(rem.i + 1, rem.j, rem.time, grid, visited, pq);
            addNeighbours(rem.i, rem.j - 1, rem.time, grid, visited, pq);
            addNeighbours(rem.i, rem.j + 1, rem.time, grid, visited, pq);
        }
        
        return -1;
    }
    
    public void addNeighbours(int i, int j, int oldTime, int[][] grid, boolean[][] visited, PriorityQueue<Pair> pq){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true){
            return;
        }
        
        pq.add(new Pair(i, j, Math.max(oldTime, grid[i][j])));
    }
}
