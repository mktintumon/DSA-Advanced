class eggDrop {

    // GFG
    static int egg_Drop(int n, int k) {
	    // n = eggs and k = floors
        int[][] dp = new int[n+1][k+1];

        //first row = XX
        //first column = 0;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=k ; j++){
                if(j == 1){
                    dp[i][j] = 1;
                }
                else if(i == 1){
                    dp[i][j] = j;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k1=j-1 , k2=0 ; k1>=0 ; k1--,k2++){
                        int x = dp[i][k1];
                        int y = dp[i-1][k2];
                        int val = Math.max(x , y);
                        min = Math.min(min , val);
                    }

                    dp[i][j] = min+1;
                }
            }
        }

        return dp[n][k];
	}

    

    //LEETCODE
    public int superEggDrop(int eggs, int n) {
        int[][] dp = new int[eggs + 1][n + 1];
        
        for(int e = 1; e <= eggs; e++){
            for(int f = 1; f <= n; f++){
                if (e == 1 || f <= 1){
                    dp[e][f] = f;
                } else {
                    int lo = 1;
                    int hi = f;
                    while(lo < hi){
                        int mid = (lo + hi) / 2;
                        int t1 = dp[e - 1][mid - 1];
                        int t2 = dp[e][f - mid];
                        
                        if(t1 < t2){
                            lo = mid + 1;
                        } else if(t2 < t1) {
                            hi = mid;
                        } else {
                            lo = mid;
                            break;
                        }
                    }
                    
                    dp[e][f] = 1 + Math.max(dp[e - 1][lo - 1], dp[e][f - lo]);
                }
            }
        }
        
        return dp[eggs][n];
    }

}