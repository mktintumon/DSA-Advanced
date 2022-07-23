import java.util.ArrayDeque;

class asFarFromLand {
    class Pair{
        int i;
        int j;
        int level;
        
        Pair(int i , int j , int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    
    public int maxDistance(int[][] grid) {
       ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        int countZero = 0;
        int countOne = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1){
                    qu.add(new Pair(i , j , 0));
                    countOne++;
                }
                countZero++;
            }
        }
        
        if(countZero == 0) return -1; // if all cell is of value -> 0 
        if(countOne == grid.length * grid[0].length) return -1; // all cell -> 1
        
        int distance = -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            
            visited[rem.i][rem.j] = true;
            
            //work
            distance = rem.level;
            
            //add neighbour
            addNeighbours(grid , visited , rem.i-1 , rem.j ,rem.level+1, qu);
            addNeighbours(grid , visited , rem.i+1 , rem.j ,rem.level+1, qu);
            addNeighbours(grid , visited , rem.i , rem.j-1 ,rem.level+1, qu);
            addNeighbours(grid , visited , rem.i , rem.j+1 ,rem.level+1, qu);
        }
        
        return distance;
    }
    
    public void addNeighbours(int[][] mat , boolean[][] visited , int i , int j , int level, ArrayDeque<Pair> qu){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || visited[i][j] == true){
            return ;
        }
        
        qu.add(new Pair(i , j , level));
    } 
}