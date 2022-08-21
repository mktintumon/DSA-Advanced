
class floydWarshallAlgo{
    
    public void shortest_distance(int[][] matrix){
        int n = matrix.length;
        
        for(int v=0 ; v<n ; v++){
            // now travel in each cell of matrix 
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(matrix[i][v] == -1){
                        continue;
                    }
                    else if(matrix[v][j] == -1){
                        continue;
                    }
                    else if(matrix[i][j] == -1){
                        //update by making v as intermediate
                        matrix[i][j] = matrix[i][v] + matrix[v][j];
                    }
                    else{
                        //update by fighting
                        matrix[i][j] = Math.min(matrix[i][j] , matrix[i][v] + matrix[v][j]);
                    }
                }
            }
        }
    }
}
