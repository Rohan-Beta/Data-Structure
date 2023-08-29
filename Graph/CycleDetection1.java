// Cycle Detection in directed graph
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

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 0));
    }
    // cycle detection

    public static boolean isCycleDirected(ArrayList<Edge> graph[] , boolean visited[] , int curr , boolean rec[]) {

        visited[curr] = true;
        rec[curr] = true;

        // get neighbour

        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            // if neighbour does not exist in rec[] but already in visited[] , we dont call the function

            // cycle condition
            if(rec[e.dest] == true) {
                return true;
            }

            else if(visited[e.dest] == false) { // if neighbour is unvisited , we make it visited
                if(isCycleDirected(graph, visited, e.dest, rec)) { // check whether a cycle is exist on that neighbour
                    return true;
                }
            }
        }
        
        rec[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        int v = 4; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean visited[] = new boolean[v];
        boolean rec[] = new boolean[v];

        for(int i = 0; i < v; i += 1) {
            if(visited[i] == false) { // check every node is visited or not

                if(isCycleDirected(graph, visited, 0, rec)) { // check for single cycle in graph
                    System.out.print(isCycleDirected(graph, visited, 0, rec));
                    break;
                }
                else { // if cycle does not exist
                    System.out.println(isCycleDirected(graph, visited, 0, rec));
                    break;
                }
            }
        }

    }
}
