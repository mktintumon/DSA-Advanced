import java.util.*;

public class revision{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        // int ans = fibT(n , dp);
        int ans = climbStairVarJump(n , dp);
        
        System.out.println(ans);
        sc.close();
    }

    public static int fibR(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int nm1 = fibR(n - 1);
        int nm2 = fibR(n - 2);
        return nm1 + nm2;
    }

    public static int fibM(int n , int[] dp) {
        if(n == 0 || n == 1) return dp[n] = n;

        if(dp[n] != 0) return dp[n];

        int nm1 = fibM(n - 1 , dp);
        int nm2 = fibM(n - 2 , dp);
        dp[n] = nm1 + nm2;
        return dp[n];
    }

    public static int fibT(int n , int[] dp) {
        // direction---->
        for(int i = 0; i <= n; i++){
            if(i == 0){
                dp[i] = 0;
            }
            else if(i == 1){
                dp[i] = 1;
            } 
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    
    // three steps allowed
    public static int climbStair(int n , int[] dp){
        dp[n] = 1; // forr path -> 1  || forr move -> 0
        for(int i=n-1 ; i>=0 ; i--){
            if(i == n-1){
                dp[i] = dp[i+1];
            }
            else if(i == n-2){
                dp[i] = dp[i+1] + dp[i+2];
            }
            else{
                dp[i] = dp[i+1] + dp[i+2] + dp[i+3];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static int climbStairVarJump(int n , int[] dp){
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        dp[n] = 1; 
        for(int i = n-1 ; i >= 0 ; i--){
            for(int step=1 ; step <= arr[i] && i+step<=n ; step++){
                dp[i] += dp[i+step] ;
            }
        }

        return dp[0];
    }  
}
