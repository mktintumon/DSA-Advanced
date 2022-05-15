
public class mazePaths {

    public static boolean inRange(int i, int j, int [][] arr){
        int n = arr.length;
        int m = arr[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }

    public static boolean inRange(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }

    public static void mazePath(){
        int n = 3;
        int m = 4;
        String [] dirN = {"H", "V", "D"};
        int [][] dir = {{0,1}, {1,0}, {1,1}};

        // int ans = mazePath_01(0,0,n-1,m-1,dir, dirN, "");
        int ans = mazePath_02(0,0,n-1,m-1,dir, dirN, "");
        System.out.println(ans);
    }

    // without jump
    public static int mazePath_01(int sr, int sc, int dr, int dc, int [][] dir, String [] dirN, String asf){
        if(sr == dr && sc == dc){
            System.out.println(asf);
            return 1;
        }

        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1)){
                count += mazePath_01(r,c, dr, dc, dir, dirN, asf + dirN[d]);
            }
        }
        return count;
    }

    //With Jumps
    public static int mazePath_02(int sr, int sc, int dr, int dc, int [][] dir, String [] dirN, String path){
        if(sr == dr && sc == dc){
            System.out.println(path);
            return 1;
        }

        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            
            for(int move = 1; move <= Math.max(dr, dc); move++){

                int r = sr + (dir[d][0] * move);
                int c = sc + (dir[d][1] * move);

                if(inRange(r,c,dr + 1, dc + 1)){
                    count += mazePath_02(r,c, dr, dc, dir, dirN, path + dirN[d] + move);
                }
            }

            
        }
        return count;

    }

    public static void floodfill(){
        int n = 3;
        int m = 3;

        String[] dirN = {"A" , "B" , "C" , "D" , "E" , "F" , "G" ,"H"};
        int[][] dir = {{-1,-1} , {-1,0} , {-1,1} , {0,1} , {1,1} , {1,0} , {1,-1} , {0,-1}};

        boolean[][] vis = new boolean[n][m];
        int ans = floodFill_01(0, 0, n-1, m-1 , vis , dir , dirN , "");
        System.out.println(ans);
    }

    public static int floodFill_01(int sr , int sc , int dr , int dc , boolean[][] vis , int[][] dir , String[] dirN , String path){
        if(sr == dr && sc == dc){
            System.out.println(path);
            return 1;
        }

        int count  = 0;
        vis[sr][sc] = true;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1) && !vis[r][c]){
                count += floodFill_01(r,c, dr, dc,vis, dir, dirN, path + dirN[d]);
            }
        }

        vis[sr][sc] = false;
        return count;
    }

    public int uniquePath(int n , int m){
        int [][] dir = {{0,1}, {1,0}};
        int[][] dp = new int[n][m];
        int ans = uniquePath_01(0,0,n-1,m-1,dir ,dp);
        return ans;
    }
    
     public int uniquePath_01(int sr, int sc, int dr, int dc, int [][] dir ,int[][] dp){
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
         
         if(dp[sr][sc] != 0){
             return dp[sr][sc];
         }

        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1)){
                count += uniquePath_01(r,c, dr, dc, dir,dp);
            }
        }
        return dp[sr][sc] = count;
    }

    public int uniquePathObstacle(int n , int m , int[][] grid){
        int [][] dir = {{0,1}, {1,0}};
        int[][] dp = new int[n][m];
        int ans = uniquePathObstacle_01(0,0,n-1,m-1,dir ,dp , grid);
        return ans;
    }
    
     public int uniquePathObstacle_01(int sr, int sc, int dr, int dc, int [][] dir ,int[][] dp , int[][] grid){
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
         
         if(dp[sr][sc] != 0){
             return dp[sr][sc];
         }

        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1) && grid[r][c] == 0){
                count += uniquePathObstacle_01(r,c, dr, dc, dir,dp , grid);
            }
        }
        return dp[sr][sc] = count;
    }

    public static void main(String[] args) {
        //mazePath();
        //uniquePath();
        //uniquePathObstacle();
        //floodfill();
    }
}
