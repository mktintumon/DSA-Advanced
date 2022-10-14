import java.util.*;

class catlan{
    public static void main(String[] args) {
        catlanNum(10);
    }

    public static void catlanNum(int num) {
        int[] dp = new int[num+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < dp.length; i++){
            int left = 0;
            int right = i-1;

            while(left <= i-1){
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
