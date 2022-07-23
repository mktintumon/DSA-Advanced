import java.util.ArrayDeque;

class matrix_01 {
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
    
    public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i , j , 0));
                }
            }
        }
        
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            
            visited[rem.i][rem.j] = true;
            
            //work
            mat[rem.i][rem.j] = rem.level;
            
            //add neighbour
            addNeighbours(mat , visited , rem.i-1 , rem.j ,rem.level+1, qu);
            addNeighbours(mat , visited , rem.i+1 , rem.j ,rem.level+1, qu);
            addNeighbours(mat , visited , rem.i , rem.j-1 ,rem.level+1, qu);
            addNeighbours(mat , visited , rem.i , rem.j+1 ,rem.level+1, qu);
        }
        
        return mat;
    }
    
    public void addNeighbours(int[][] mat , boolean[][] visited , int i , int j , int level, ArrayDeque<Pair> qu){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || visited[i][j] == true){
            return ;
        }
        
        qu.add(new Pair(i , j , level));
    }
}