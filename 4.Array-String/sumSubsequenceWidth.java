import java.util.*;

/*
   # let sorted array = [a , b , c , d] --> (max = d and min = a)
   
   # Its subsequence is 2^n -->     _ _ _ _      a _ _ _
                                    _ _ _ d      a _ _ d
                                    _ _ c _      a _ c _ 
                                    _ _ c d      a _ c d
                                    _ b _ _      a b _ _
                                    _ b _ d      a b _ d
                                    _ b c _      a b c _
                                    _ b c d      a b c d

    # Width = maxEle - minEle
    # Above sum summaray -->  ( +8d +4c +2b +a ) + ( -8a -4b - 2c -d)
                         
      --> [ (1.a - 1.d) + (2.b - 2.c) + (4.c - 4.b) + (8.d - 8.a) ]                          

*/

class sumSubsequenceWidth{
    long MOD = 1000000007L;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        
        long ans = 0;
        long mul = 1;
        int j = nums.length-1;   
        
        for(int i=0 ; i<nums.length ; i++){
            ans = (ans + mul*nums[i] - mul*nums[j]) % MOD;
            mul = (2 * mul) % MOD;
            j--;
        }  
        
        return (int)ans;
    }
}