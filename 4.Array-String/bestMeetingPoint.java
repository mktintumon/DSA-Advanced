import java.util.*;

public class bestMeetingPoint{

    public static int minTotalDistance(int[][] grid) {

        ArrayList<Integer> x_cord = new ArrayList<>();
        ArrayList<Integer> y_cord = new ArrayList<>();

        // for row coordinates
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    x_cord.add(r);
                }
            }
        }

        // for col coordinates
        for(int c = 0; c < grid[0].length; c++) {
            for(int r = 0; r < grid.length; r++) {
                if(grid[r][c] == 1) {
                    y_cord.add(c);
                }
            }
        }

        // our meeting point will be (x , y) calculated below
        int x = x_cord.get(x_cord.size() / 2);
        int y = y_cord.get(y_cord.size() / 2);
        
        // calculate distance
        // finding the distance from median point
        // we can use 2 different loops for finding the distance
        // but Arraylists -->  length(x_cord) == length(y_cord) 
        int dist = 0;
        for(int i = 0; i < x_cord.size(); i++) {
            dist += Math.abs(x_cord.get(i) - x) + Math.abs(y_cord.get(i) - y);
        }
        return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
        scn.close();
    }
}