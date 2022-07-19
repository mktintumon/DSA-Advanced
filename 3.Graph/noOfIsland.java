
public class noOfIsland {
    
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid , i , j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid , int i , int j){
        // mark 
        grid[i][j] = '0';
        
        for(int d=0 ; d<dir.length ; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == '1'){
                dfs(grid , r , c);
            }
        }
    }
}

//    ************   APPROACH - 2 *************

class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    traverse(grid, visited, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void traverse(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        } else if(grid[i][j] == '0'){
            return;
        } else if(visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        traverse(grid, visited, i - 1, j);
        traverse(grid, visited, i + 1, j);
        traverse(grid, visited, i, j - 1);
        traverse(grid, visited, i, j + 1);
    }
}