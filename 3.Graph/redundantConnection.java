class redundantConnection {

    static int[] parent;
    static int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for (int i = 1; i < edges.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];

            int srcLead = find(x);
            int nbrLead = find(y);

            if (srcLead != nbrLead) {
                union(srcLead, nbrLead);
            } else {
                return e;
            }
        }

        return null;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public void union(int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[y] < rank[x]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }
}