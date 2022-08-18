class bricksFallingWhenHit {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        // marking -1 to bricks which will get hit
        for (int[] box : hits) {
            int i = box[0];
            int j = box[1];
            if (grid[i][j] == 1){
                grid[i][j] = -1;
            }
        }
        
        for (int j = 0; j < grid[0].length; j++) {
            connect(grid, 0, j);
        }
        
        // reverse travel in hits[][]
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];
            
            if (grid[row][col] == -1) {
                grid[row][col] = 1;
                if (connectedToTop(grid, row, col)) {
                    // brick hitted will be disappear -> exclude -> (ans-1)
                    res[i] = connect(grid, row, col) - 1;
                }
            }
        }
        return res;
    }
    
    public boolean connectedToTop(int[][] grid, int i, int j) {
        if (i == 0) return true;
        
        if (i - 1 >= 0  &&  grid[i - 1][j] == 2) return true;
        if (j - 1 >= 0  &&  grid[i][j - 1] == 2) return true;
        if (i + 1 < grid.length  &&    grid[i + 1][j] == 2) return true;
        if (j + 1 < grid[0].length &&  grid[i][j + 1] == 2) return true;
        
        return false;
    }
    
    public int connect(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
           return 0; 
        } 
        
        // mark 2 as safe
        grid[i][j] = 2;
        int count = 1;
        
        count += connect(grid, i - 1, j);
        count += connect(grid, i + 1, j);
        count += connect(grid, i, j + 1);
        count += connect(grid, i, j - 1);
        
        return count;
    }
}