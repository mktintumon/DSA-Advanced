class distinctSubsequence2 {
    
    public int distinctSubseqII(String s) {
      long MOD = 1000000007;
      long[] dp = new long[s.length()+1];
      dp[0] = 1; // empty set
      dp[1] = 2;  

      int[] charFreq = new int[26];
      charFreq[s.charAt(0) - 'a'] = 1;

      for(int i=2 ; i<dp.length ; i++){
          dp[i] = (dp[i-1] * 2) % MOD;

          // if character repeats --> subtract something
          int ch = s.charAt(i-1) - 'a';
          if(charFreq[ch] != 0){
              dp[i] = (dp[i] - dp[charFreq[ch]-1] + MOD) % MOD;
          }

          charFreq[ch] = i;
      }

      return (int)dp[s.length()] - 1; // removes empty set
    }
}
