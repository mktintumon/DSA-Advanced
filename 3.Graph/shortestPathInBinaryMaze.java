import java.util.*;

public class shortestPathInBinaryMaze {
    class Pair{
        int x;
        int y;
        int count;
        
        Pair(int x , int y , int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    int shortestPath(int[][] grid, int[] src, int[] dest) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(src[0],src[1],0));
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(visited[rem.x][rem.y] == true){
                continue;
            }
            
            visited[rem.x][rem.y] = true;
            
            if(rem.x == dest[0] && rem.y == dest[1]){
                return rem.count;
            }
            
            addNeighbours(rem.x-1 , rem.y , rem.count+1,grid , visited , qu);
            addNeighbours(rem.x+1 , rem.y , rem.count+1,grid , visited , qu);
            addNeighbours(rem.x , rem.y-1 , rem.count+1,grid , visited , qu);
            addNeighbours(rem.x , rem.y+1 , rem.count+1,grid , visited , qu);
        }
        
        return -1;
    }
    
    public void addNeighbours(int x , int y ,int count, int[][] grid ,boolean[][] visited, Queue<Pair> qu){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] == true || grid[x][y] == 0){
            return;
        }
        
        qu.add(new Pair(x , y,count));
    }
} 