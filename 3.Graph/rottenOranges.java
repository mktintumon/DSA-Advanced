import java.util.*;

class rottenOranges {
    class Pair{
        int i;
        int j;
        int t;
        
        Pair(int i , int j , int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        int fresh = 0;
        
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i , j , 0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            } 
        }

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int time = 0;
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            // if we write grid[i][j] == 2; continue; --> 
            //-->this will skip the while loop and queue become empty
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            
            vis[rem.i][rem.j] = true;
            
            if(rem.t > time ) time = rem.t;
            
            if(grid[rem.i][rem.j] == 1) fresh--;
                
            addNeighbours(rem.i+1 , rem.j , rem.t+1 , grid , qu , vis); 
            addNeighbours(rem.i-1 , rem.j , rem.t+1 , grid , qu , vis); 
            addNeighbours(rem.i , rem.j+1 , rem.t+1 , grid , qu , vis); 
            addNeighbours(rem.i , rem.j-1 , rem.t+1 , grid , qu , vis); 
            
            
            }
        
            if(fresh == 0){
                return time;
            }
            else{
                return -1;
            }
    }
    
    public void addNeighbours(int i , int j , int t , int[][] grid , ArrayDeque<Pair> qu , boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] == 0 || vis[i][j] == true){
            return;
        }
        
        qu.add(new Pair(i , j , t));
    }
}