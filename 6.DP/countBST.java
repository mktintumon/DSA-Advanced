public class countBST {

    // LEETCODE
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2 ; i<=n ; i++){
            for(int left = 0 ; left <= i-1 ; left++){
                int right = i - left - 1; // -1 for root
                int val = dp[left] * dp[right] ;
                dp[i] = dp[i] + val ;
            }
        }
        
        return dp[n];
    }

    // GFG
    static int num_Trees(int N){
        long mod = 1000000007;
        
        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2 ; i<=N ; i++){
            for(int left = 0 ; left <= i-1 ; left++){
                int right = i - left - 1; // -1 for root
                long val = (dp[left] * dp[right]) % mod;
                dp[i] = (dp[i] + val) % mod;
            }
        }
        
        return (int)dp[N];
    }
}
