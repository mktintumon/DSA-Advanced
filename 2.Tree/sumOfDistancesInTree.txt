import java.util.*;

class sumOfDistancesInTree {
    public int[] sumOfDistances(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] nodes = new int[n]; // no of nodes array
        int[] res = new int[n];   // no of edges array

        //start with parent -1
        helper1(graph, nodes, res, 0, -1);
        helper2(graph, nodes, res, 0, -1);

        return res;   
    }

    //this fn will set the result of only first idx
    public void helper1(ArrayList<Integer>[] graph, int[] nodes, int[] res, int src, int par){
        for(int nbr: graph[src]){
            if(nbr != par){
                helper1(graph, nodes, res, nbr, src);
                nodes[src] += nodes[nbr];
                res[src] += nodes[nbr] + res[nbr];
            }
        }

        nodes[src]++;
    }

    // finding result of rest of the idx
    public void helper2(ArrayList<Integer>[] graph, int[] nodes, int[] res, int src, int par){
        for(int nbr: graph[src]){
            if(nbr != par){
                res[nbr] = res[src] + (nodes.length - nodes[nbr]) - (nodes[nbr]);
                helper2(graph, nodes, res, nbr, src);
            }
        }
    }    
}