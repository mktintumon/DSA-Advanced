import java.util.*;

class dijkstraAlgo {
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
      String path;

      Pair(int v, int cost, String path) {
         this.v = v;
         this.cost = cost;
         this.path = path;
      }
   }

   public void algo(ArrayList<Edge>[] graph, int src) {
      PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
         return a.cost - b.cost;
      });

      pq.add(new Pair(0, 0, src + ""));

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
         System.out.println(rem.v + " via " + rem.path + " @ " + rem.cost);

         // add neighbour
         for (Edge e : graph[rem.v]) {
            if (visited[e.nbr] == false) {
               pq.add(new Pair(e.nbr, rem.cost + e.wt, rem.path + e.nbr));
            }
         }
      }
   }
}