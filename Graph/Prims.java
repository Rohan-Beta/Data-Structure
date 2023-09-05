// Prims Algorithm
// it use MST

// time complexity is O(ElogE) , V = vertices and E = edges 

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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
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
    // prims

    public static void prims(ArrayList<Edge> graph[] , int ver) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[ver];

        int mstDist = 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(vis[curr.node] == false) {
                vis[curr.node] = true;

                mstDist += curr.dist;

                for(int i = 0; i < graph[curr.node].size(); i += 1) {
                    Edge e = graph[curr.node].get(i);

                    if(vis[e.dest] == false) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }

            }
        }
        System.out.print(mstDist);
    }

    public static void main(String args[]) {
        int v = 4; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean vis[] = new boolean[v];

        prims(graph, v);
    }
}
