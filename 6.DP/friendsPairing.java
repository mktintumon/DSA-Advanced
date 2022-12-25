
class friendsPairing{
    public long countFriendsPairings(int n) { 
       Long[] dp = new Long[n+1];
       for(int i=0 ; i<=n ; i++){
           if(i <= 2){
               dp[i] = (long)i;
               continue;
           }
           
           dp[i] = (dp[i-1] + (i-1)*dp[i-2]) % 1000000007;
       }
       
       return dp[n];
    }
}  
