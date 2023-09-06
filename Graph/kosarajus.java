// kosarajus Algorithm
// it use reverse bfs

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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }
    // topological sorting

    public static void topSorting(ArrayList<Edge> graph[] , int curr , boolean vis[] , Stack<Integer> stack) {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            if(vis[e.dest] == false) {
                topSorting(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }
    // dfs

    public static void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[]) {
        
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            if(vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    // kosaraju

    public static void kosaraju(ArrayList<Edge> graph[] , int v) {

        // step 1:
        // store topological sorting order in stack

        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[v];

        for(int i = 0; i < v; i += 1) {
            if(vis[i] == false) {
                topSorting(graph, i, vis, stack);
            }
        }

        // step 2:
        // create a clone graph to store transpose of the graph

        ArrayList<Edge> transpose[] = new ArrayList[v];

        for(int i = 0; i < transpose.length; i += 1) {
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < v; i += 1) {
            for(int j = 0; j < graph[i].size(); j += 1) {
                Edge e = graph[i].get(j); // e.src -> e.dest

                transpose[e.dest].add(new Edge(e.dest, e.src)); // transpose (e.dest -> e.src)

            }
        }

        // step 3:
        // doing DFS according to stack nodes

        boolean vis1[] = new boolean[v];

        while(!stack.isEmpty()) {
            int curr = stack.pop();

            if(vis1[curr] == false) {
                dfs(transpose, curr, vis1);
                System.out.print("\n");
            }
        }
    }

    public static void main(String args[]) {
        int v = 5; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean vis[] = new boolean[v];
        kosaraju(graph, v);
    }
}
