import java.util.*;

public class highwayBillboard{

    public static int solution(int m , int[] x, int[] rev, int t) {
        int[] dp = new int[x.length];
        dp[0] = rev[0];

        int max = rev[0];

        for(int i = 1; i < dp.length; i++) {
            int currMax = 0;
            for(int j=0 ; j<i ; j++){
                //check if satisfy limit t
                if(x[j] + t < x[i]){
                    currMax = Math.max(currMax, x[j]);
                }

                // currMax here will be 0 if limit not satisfied
                dp[i] = currMax + rev[i];
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }


    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }


    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
