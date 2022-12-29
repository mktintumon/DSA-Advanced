
class minScoreTriangulationPolygon {
    
    public int minScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for(int gap = 0 ; gap < dp[0].length ; gap++){
            for(int i=0 , j = gap ; j < dp[0].length ; i++ , j++){
                if(gap == 0) dp[i][j] = 0;
                else if(gap == 1) dp[i][j] = 0;
                else if(gap == 2){
                    dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
                }
                else{
                    dp[i][j] = Integer.MAX_VALUE;

                    // lk = left k  and rk = right k
                    for(int lk=gap-1 , rk=1 ; lk>=1 ; rk++ , lk--){
                        int left = dp[i][j - lk];
                        int right = dp[i + rk][j];
                        // [i + rk] == [j - lk]
                        int joinCost = arr[i] * arr[i + rk] * arr[j];
                        
                        dp[i][j] = Math.min(dp[i][j] , left+right+joinCost);
                    }
                }
            }
        }

        return dp[0][dp[0].length-1];
    }
}
