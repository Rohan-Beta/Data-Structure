// Graph
// Adjacency List
// time complexity O(x) , x = number of neighbour

// in adjacency list we always use array of ArrayList
// ArrayList<Edge> graph[Vertices]

// undirected and unweighted graph

import java.util.*;

class Firstclass {

    static class Edge {
        int src;
        int dest;

        Edge(int s , int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {

        // initilize ArraList index value with empty value

        for(int i = 0; i < graph.length; i += 1) {
            graph[i] = new ArrayList<Edge>();
        }
        // adding neighbour in ArrayList

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(2, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }
    public static void main(String args[]) {
        int v = 4; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        // print neighbour of selected vertex

        for(int i = 0; i < graph[2].size(); i += 1) {
            Edge e = graph[2].get(i); // get index in array list
            
            System.out.print(e.src + " ");
            System.out.print(e.dest + " ");
            System.out.print("\n");
        }
    }
}
