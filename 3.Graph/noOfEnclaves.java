class noOfEnclaves {
    int length = 0;
    boolean flag = true;
    public int numEnclaves(int[][] grid) {
    
        int count = 0;
        
        // not travel for boundary elements
        for(int i=1 ; i<grid.length-1 ; i++){
           for(int j=1 ; j<grid[0].length-1 ; j++){
               
               if(grid[i][j] == 1){
                  flag = true;
                  length = 0;
                  dfs(grid , i , j);
               
                  if(flag == true){
                     count += length;
                  }
               }
           }
        }
        
        return count;
    }
    
    public void dfs(int[][] grid , int i , int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            flag = false;
            return;
        }
        else if(grid[i][j] == 0){
           return; 
        }
        
        //mark
        grid[i][j] = 0;
        length++;
        
        dfs(grid , i-1 , j);
        dfs(grid , i+1 , j);
        dfs(grid , i , j-1);
        dfs(grid , i , j+1);
        
    }
}