class regionsCutBySlashes {

    static int[] parent;
    static int[] rank;

    public int regionsBySlashes(String[] grid) {
        parent = new int[4 * grid.length * grid.length];
        rank = new int[4 * grid.length * grid.length];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        // i is for array  and j  is for string 
        // here j < grid[i].length()
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                int boxNo = i * grid.length + j;

                // int cellNo = 4*boxNo + (0,1,2,3)

                if (ch != '/') {
                    unionHelper(4 * boxNo + 0, 4 * boxNo + 1);
                    unionHelper(4 * boxNo + 2, 4 * boxNo + 3);
                }
                if (ch != '\\') {
                    unionHelper(4 * boxNo + 0, 4 * boxNo + 3);
                    unionHelper(4 * boxNo + 1, 4 * boxNo + 2);
                }

                // merging the internal border cells
                if (i > 0) {
                    int nbrBoxNo = (i - 1) * grid.length + j;
                    unionHelper(4 * boxNo + 0, 4 * nbrBoxNo + 2);
                }

                if (j > 0) {
                    int nbrBoxNo = i * grid.length + (j - 1);
                    unionHelper(4 * boxNo + 3, 4 * nbrBoxNo + 1);
                }
                if (i < grid.length - 1) {
                    int nbrBoxNo = (i + 1) * grid.length + j;
                    unionHelper(4 * boxNo + 2, 4 * nbrBoxNo + 0);
                }

                if (j < grid[0].length() - 1) {
                    int nbrBoxNo = i * grid.length + (j + 1);
                    unionHelper(4 * boxNo + 1, 4 * nbrBoxNo + 3);
                }
            }
        }

        // finally return count of parent array index having same index value
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }

        return count;
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    void union(int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[y] < rank[x]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }

    void unionHelper(int x, int y) {
        int srcLead = find(x);
        int nbrLead = find(y);

        if (srcLead != nbrLead) {
            union(srcLead, nbrLead);
        }
    }
}
