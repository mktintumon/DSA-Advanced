import java.util.*;

public class revision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // int[] dp = new int[n+1];
        int ans = maxGoldmine(n, m);

        System.out.println(ans);
        sc.close();
    }

    public static int fibR(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int nm1 = fibR(n - 1);
        int nm2 = fibR(n - 2);
        return nm1 + nm2;
    }

    public static int fibM(int n, int[] dp) {
        if (n == 0 || n == 1)
            return dp[n] = n;

        if (dp[n] != 0)
            return dp[n];

        int nm1 = fibM(n - 1, dp);
        int nm2 = fibM(n - 2, dp);
        dp[n] = nm1 + nm2;
        return dp[n];
    }

    public static int fibT(int n, int[] dp) {
        // direction---->
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    // three steps allowed
    public static int climbStair(int n, int[] dp) {
        dp[n] = 1; // forr path -> 1 || forr move -> 0
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                dp[i] = dp[i + 1];
            } else if (i == n - 2) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1] + dp[i + 2] + dp[i + 3];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static int climbStairVarJump(int n, int[] dp) {
        int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int step = 1; step <= arr[i] && i + step <= n; step++) {
                dp[i] += dp[i + step];
            }
        }

        return dp[0];
    }

    public static int minSteps(int n) {
        int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        Integer[] dp = new Integer[n + 1]; // default -> null
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int step = 1; step <= arr[i] && i + step <= n; step++) {
                if (dp[i + step] != null) {
                    min = Math.min(min, dp[i + step]);
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            } else {
                dp[i] = null;
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static int minCostMazePath(int n, int m) {
        int[][] cost = {
                { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 },
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 },
                { 2, 7, 0, 8, 5, 1 }
        };

        int[][] dp = new int[n][m];

        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {
                if (r == n - 1 && c == m - 1) {
                    dp[r][c] = cost[r][c];
                } else if (r == n - 1) {
                    dp[r][c] = dp[r][c + 1] + cost[r][c];
                } else if (c == m - 1) {
                    dp[r][c] = dp[r + 1][c] + cost[r][c];
                } else {
                    int min = Math.min(dp[r + 1][c], dp[r][c + 1]);
                    dp[r][c] = min + cost[r][c];
                }
            }
        }

        return dp[0][0];
    }

    public static int maxGoldmine(int n, int m) {
        int[][] gold = {
                { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 },
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 },
                { 2, 7, 0, 8, 5, 1 }
        };

        int[][] dp = new int[n][m];

        // direction <-----
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (j == n - 1) {
                    dp[i][j] = gold[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + gold[i][j];
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + gold[i][j];
                } else {
                    int max = Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                    dp[i][j] = max + gold[i][j];
                }
            }
        }

        // searching in first column
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}
