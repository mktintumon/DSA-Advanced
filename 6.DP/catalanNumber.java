import java.util.*;

/*
  APPLICATIONS: 
   1) count number of BST
   2) count Brackets
   3) count valleys and mountains
   4) upper diagonal Maze travel
   5) Dyck path / Dyck word
   6) circles and non intersecting chords 
   7) Triangulations
*/

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
