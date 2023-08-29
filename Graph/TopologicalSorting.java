// Topological Sorting
// condition: topological sorting works only in directed graph which contains no cycle in the graph

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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    // topological sorting

    public static void topSorting(ArrayList<Edge> graph[] , int curr , boolean visited[] , Stack<Integer> stack) {
        visited[curr] = true;

        // get neighbour

        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            if(visited[e.dest] == false) { // if neighbour is unvisited
                topSorting(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String args[]) {
        int v = 6; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < v; i += 1) {
            if(visited[i] == false) {
                topSorting(graph, i, visited, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
