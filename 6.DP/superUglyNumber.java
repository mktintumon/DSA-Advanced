import java.util.*;

class superUglyNumber {

    // same approach as ugly number - 2

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n+1];
        dp[1] = 1;

        // setting start of pointers
        int[] pointer = new int[primes.length];
        Arrays.fill(pointer , 1);

        for(int i=2 ; i<=n ; i++){
            long ans = Integer.MAX_VALUE;
            for(int j=0 ; j<primes.length ; j++){
                int prime = primes[j];
                int p = pointer[j];

                ans = Math.min(ans , dp[p]*prime);
            }

            dp[i] = ans;

            // moving pointers forward whichever eligible
            for(int j=0 ; j<primes.length ; j++){
                int prime = primes[j];
                int p = pointer[j];

                if(ans == dp[p]*prime) pointer[j]++;
            }
        }

        return (int)dp[n];
    }
}
