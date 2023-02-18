class uglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1; //fixed

        // setting pointer of 2 3 5
        int p2, p3, p5;
        p2 = p3 = p5 = 1;

        for(int i=2 ; i<=n ; i++){
            int mul2 = dp[p2] * 2;
            int mul3 = dp[p3] * 3;
            int mul5 = dp[p5] * 5;

            dp[i] = Math.min(mul2 , Math.min(mul3 , mul5));

            // moving pointer forward which are eligible
            if(dp[i] == mul2) p2++;
            if(dp[i] == mul3) p3++;
            if(dp[i] == mul5) p5++;
        }

        return dp[n];
    }
}