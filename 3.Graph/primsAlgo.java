import java.util.*;

class primsAlgo {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    class Pair {
        int v;
        int cost;

        Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public int algo(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        pq.add(new Pair(src , 0));

        int minCost = 0;
        boolean[] visited = new boolean[graph.length];

        while (pq.size() > 0) {
            // remove
            Pair rem = pq.remove();

            // mark
            if (visited[rem.v] == true) {
                continue;
            }

            visited[rem.v] = true;

            // work 
            minCost += rem.cost;

            // add neighbour
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, e.wt));
                }
            }
        }

        return minCost;
    }
}
