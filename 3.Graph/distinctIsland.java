import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class distinctIsland {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  public static StringBuilder path = new StringBuilder();

  public static int numDistinctIslands(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        HashSet<String> unique = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                if(arr[i][j] == 1 && visited[i][j] == false){
                   path = new StringBuilder();
                   dfs(arr, visited , i , j);
                   unique.add(path.toString());
                }
            }
        }
        return unique.size();
    }


    public static void dfs(int[][] arr , boolean[][] visited , int i , int j ){
        visited[i][j] = true;

        //four cases call 
    
        // TOP
        if(i-1 >= 0 && visited[i-1][j] == false && arr[i-1][j] == 1){
            path.append("T");
            dfs(arr, visited, i-1, j);
        }

        //LEFT
        if(j-1 >= 0 && visited[i][j-1] == false && arr[i][j-1] == 1){
            path.append("L");
            dfs(arr, visited, i, j-1);
        }

        //BOTTOM
        if(j+1 < arr[0].length && visited[i][j+1] == false && arr[i][j+1] == 1){
            path.append("B");
            dfs(arr, visited, i, j+1);
        }

        //Right
        if(i+1 < arr.length && visited[i+1][j] == false && arr[i+1][j] == 1){
            path.append("R");
            dfs(arr, visited, i+1, j);
        }

        path.append("Z"); // ---->Backtracing---> helps in uniqueness 
    }
}
