class probabilityOfKnights{

    public double findProb(int N, int start_x, int start_y, int step){
        double[][][] dp = new double[N][N][step+1];
        dp[start_x][start_y][0] = 1; //starting prob
        
        int[][] directions = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        
        for(int move=1 ; move<=step ; move++){
            for(int i=0 ; i<dp.length ; i++){
                for(int j=0 ; j<dp[0].length ; j++){
                    for(int[] dir : directions){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        if(x>=0 && y>=0 && x<N && y<N){
                            dp[x][y][move] += dp[i][j][move-1] / 8;
                        }
                    }
                }
            }
        }
        
        double prob = 0;
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                 prob += dp[i][j][step];
            }
        }
        
        return prob;
        
    }
}
