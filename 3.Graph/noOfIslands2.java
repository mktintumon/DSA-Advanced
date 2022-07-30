import java.util.*;
import java.io.*;

public class noOfIslands2 {

    static int count;
    static int[] parent;
    static int[] rank;

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        // making grid and assining cell number to each cell from 0 --> m*n-1
        int[][] grid = new int[m][n];
        parent = new int[m * n];
        rank = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        count = 0;

        for (int[] pos : positions) {
            //getting index of cell
            int x = pos[0];
            int y = pos[1];
            grid[x][y] = 1;

            count++;
            handleNbrCell(x, y, x - 1, y, m, n, grid);
            handleNbrCell(x, y, x + 1, y, m, n, grid);
            handleNbrCell(x, y, x, y - 1, m, n, grid);
            handleNbrCell(x, y, x, y + 1, m, n, grid);

            ans.add(count);
        }

        return ans;
    }

    public static void handleNbrCell(int x, int y, int nbrX, int nbrY, int m, int n, int[][] grid) {
        if (nbrX < 0 || nbrY < 0 || nbrX >= m || nbrY >= n || grid[nbrX][nbrY] == 0) {
            return;
        }

        // method to find cell number
        int srcCell = x * n + y;
        int nbrCell = nbrX * n + nbrY;

        int srcLead = find(srcCell);
        int nbrLead = find(nbrCell);

        if (srcLead != nbrLead) {
            count--;

            union(srcLead, nbrLead);
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public static void union(int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
        int q = Integer.parseInt(st[2]);

        int[][] pos = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(st[0]);
            pos[i][1] = Integer.parseInt(st[1]);
        }

        System.out.println(numIslands2(m, n, pos));
    }

}