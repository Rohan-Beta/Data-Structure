// Dijkstras Algorithm

// time complexity is O(E + E logV) , V = vertices and E = edges 

import java.util.*;

class Firstclass {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s , int d , int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    // create graph

    public static void createGraph(ArrayList<Edge> graph[]) {

        // initilize ArraList index value with empty value

        for(int i = 0; i < graph.length; i += 1) {
            graph[i] = new ArrayList<Edge>();
        }

        // adding neighbour in ArrayList

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        
        graph[2].add(new Edge(2, 4, 3));
        
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    // Comparable<Pair> is an interface works on Pair class so that we can compair
    // for sorting a class based on the property,  we use Comparable<>

    static class Pair implements Comparable<Pair> {
        
        int node;
        int dist;

        Pair(int n , int d) {
            this.node = n;
            this.dist = d;
        }

        // compare or sort the class base on distance
        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // for ascending order
            // return p2.dist - this.dist; // for descending order
        }
    }
    // dijkastras

    public static void dijkastras(ArrayList<Edge> graph[] , int src , int ver) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int dist[] = new int[ver];

        for(int i = 0; i < ver; i += 1) {
            if(i != src) { // check for source
                dist[i] = Integer.MAX_VALUE; // initialize value with infinity
            }
        }
        boolean vis[] = new boolean[ver];

        pq.add(new Pair(0, 0)); // adding source pair

        while(!pq.isEmpty()) {
            Pair curr = pq.remove(); // it gives shortest path

            if(vis[curr.node] == false) { // check whether the node is already visited or not
                vis[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size(); i += 1) {
                    Edge e = graph[curr.node].get(i);

                    int u = e.src;
                    int v = e.dest;

                    // relaxation
                    // relaxation update the distance with its smallest distance value

                    if(dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i = 0; i < ver; i += 1) {
            System.out.print(dist[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        int v = 6; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean vis[] = new boolean[v];

        dijkastras(graph, 0, v);
    }
}
