import java.util.*;

class coloringBorder {
    class Pair {
        int i;
        int j;
        boolean border;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        Pair p = new Pair(row, col);
        p.border = isBorder(grid, row, col);
        queue.add(p);

        ArrayList<Pair> list = new ArrayList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int orgColor = grid[row][col];

        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (vis[rem.i][rem.j] == true) {
                continue;
            }

            vis[rem.i][rem.j] = true;

            // work -> add the comp element in arrayList
            if (rem.border == true) {
                list.add(rem);
            }

            // add neighbour
            addNeighbour(grid, queue, vis, rem.i - 1, rem.j, orgColor);
            addNeighbour(grid, queue, vis, rem.i + 1, rem.j, orgColor);
            addNeighbour(grid, queue, vis, rem.i, rem.j - 1, orgColor);
            addNeighbour(grid, queue, vis, rem.i, rem.j + 1, orgColor);
        }

        // take out from arraylist and change color
        for (Pair ans : list) {
            grid[ans.i][ans.j] = color;
        }

        return grid;

    }

    public void addNeighbour(int[][] grid, ArrayDeque<Pair> queue, boolean[][] visited, int i, int j, int orgColor) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true
                || grid[i][j] != orgColor) {
            return;
        }

        Pair p = new Pair(i, j);
        p.border = isBorder(grid, i, j);
        queue.add(p);
    }

    public boolean isBorder(int[][] grid, int i, int j) {
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            // boundary elements
            return true;
        } else {
            int color = grid[i][j];
            if (grid[i - 1][j] != color || grid[i + 1][j] != color || grid[i][j - 1] != color
                    || grid[i][j + 1] != color) {
                // adjacent 4 cells with different values
                return true;
            } else {
                return false;
            }
        }
    }

}