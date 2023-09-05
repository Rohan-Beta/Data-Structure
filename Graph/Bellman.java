// Bellman Ford Algorithm

// time complexity is O(V * E) , V = vertices and E = edges 

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

        graph[1].add(new Edge(1, 2, -4));
        
        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));
        
        graph[4].add(new Edge(4, 1, -1));
    }
    // Bellman Ford

    public static void bellmanFord(ArrayList<Edge> graph[] , int src , int ver) {

        int dist[] = new int[ver];

        for(int i = 0; i < ver; i += 1) {
            if(i != src) { // check for source
                dist[i] = Integer.MAX_VALUE; // initialize value with infinity
            }
        }

        for(int k = 0; k < ver-1; k += 1) { // O(V) // longest path between two vertices is ver-1 nodes
            // so we run loop upto ver-1 to find all the possible path to find the shortest distance
            
            // O(E)
            for(int i = 0; i < ver; i += 1) {
                for(int j = 0; j < graph[i].size(); j += 1) {
                    
                    Edge e = graph[i].get(j);

                    int u = e.src;
                    int v = e.dest;

                    // relaxation
                    // relaxation update the distance with its smallest distance value

                    if(dist[u] + e.weight < dist[v] && dist[u] != Integer.MAX_VALUE) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }
        // detect negative weight cycle
        // to detect we simply run Bellman inner loop

        for(int i = 0; i < ver; i += 1) {

            for(int j = 0; j < graph[i].size(); j += 1) {
                    
                Edge e = graph[i].get(j);

                int u = e.src;
                int v = e.dest;

                // relaxation

                if(dist[u] + e.weight < dist[v] && dist[u] != Integer.MAX_VALUE) {
                    System.out.println("negative weight cycle detected");
                }
            }
        }

        // print the smallest distances

        for(int i = 0; i < dist.length; i += 1) {
            System.out.print(dist[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        int v = 5; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        bellmanFord(graph, 0, v);
    }
}
