// Graph
// Adjacency List
// time complexity O(x) , x = number of neighbour

// in adjacency list we always use array of ArrayList
// ArrayList<Edge> graph[Vertices]

// undirected and weighted graph

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
    public static void createGraph(ArrayList<Edge> graph[]) {

        // initilize ArraList index value with empty value

        for(int i = 0; i < graph.length; i += 1) {
            graph[i] = new ArrayList<Edge>();
        }
        // adding neighbour in ArrayList

        graph[0].add(new Edge(0, 2 , 2));

        graph[1].add(new Edge(1, 2 , 10));
        graph[1].add(new Edge(2, 3 , 0));

        graph[2].add(new Edge(2, 0 , 2));
        graph[2].add(new Edge(2, 1 , 10));
        graph[2].add(new Edge(2, 3 , -1));

        graph[3].add(new Edge(3, 1 , 0));
        graph[3].add(new Edge(3, 2 , -1));
    }
    public static void main(String args[]) {
        int v = 4; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        // print neighbour of selected vertex

        for(int i = 0; i < graph[2].size(); i += 1) {
            Edge e = graph[2].get(i); // get index in array list
            
            System.out.print(e.src + " , " + e.dest + " , " + e.weight);
            System.out.print("\n");
        }
    }
}
