// Cycle Detection in Undirected graph
// for connected and disconnected graph

// time complexity is O(V + E) , V = vertices and E = edges 

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
    // create graph

    public static void createGraph(ArrayList<Edge> graph[]) {

        // initilize ArraList index value with empty value

        for(int i = 0; i < graph.length; i += 1) {
            graph[i] = new ArrayList<Edge>();
        }

        // adding neighbour in ArrayList

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }
    // cycle detection

    public static boolean isCycleUndirected(ArrayList<Edge> graph[] , boolean vis[] , int curr , int par) {

        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            if(vis[e.dest] == true && e.dest != par) { // already visited but not a parent node
                return true;
            }
            else if(vis[e.dest] == false) { // if neighbour is unvisited , we make it visited
                if(isCycleUndirected(graph, vis, e.dest, curr)) { // check whether a cycle is exist on that neighbour
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int v = 6; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean vis[] = new boolean[v];

        System.out.println(isCycleUndirected(graph, vis, 0, -1));
    }
}
