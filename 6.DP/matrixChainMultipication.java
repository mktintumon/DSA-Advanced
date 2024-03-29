class matrixChainMultipication{


    /*
    MCM PATTERN QUESTIONS

    1) Min and Max value of expression
    2) Optimal BST
    3) Burst Balloons
    4) Min score Triangulation of Polygon
    5) Longest common substring
    6) count of longest palindromic substring
    7) longest palindromic substring
    8) count of palindromic subsequences
    9) palindromic partition
    10) palindromic partition - 2
    11 longest palindromic subsequence
    12) longest common Subsequence
     
    */

    static int matrixMultiplication(int N, int arr[]){
        int[][] dp = new int[arr.length-1][arr.length-1];
        
        for(int gap = 0 ; gap < dp[0].length ; gap++){
            for(int i=0 , j=gap ; j < dp[0].length ; i++ , j++){
                if(gap == 0){
                    dp[i][j] = 0;
                }
                else if(gap == 1){
                    dp[i][j] = arr[i] * arr[j] * arr[j+1];
                }
                else{
                    int min = Integer.MAX_VALUE;

                    // k1 = right side k  and k2 = left side k
                    for(int k1=1 , k2=gap ; k1<=gap ; k1++ , k2--){
                        int left = dp[i][j-k2];   // dim[] = (arr[i] , arr[j-k2+1])
                        int right = dp[i+k1][j];  // dim[] = (arr[i+k1] , arr[j+1])
                                                  // therefore arr[i+k1] == arr[j-k2+1] 
                        int multCost = arr[i] * arr[j+1] * arr[i+k1];
                        
                        min = Math.min(min , left+right+multCost); 
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp.length-1];
    }
}
