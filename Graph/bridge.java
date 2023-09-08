// Tarjans Algorithm for Bridge in graph

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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }
    // dfs

    public static void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[], 
                            int dt[] , int ldt[] , int time , int par) {
        
        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            // if neighbour is parent then ignore

            if(e.dest == par) {
                continue;
            }
            // for unvisited neighbour

            else if(vis[e.dest] == false) {
                dfs(graph, e.dest, vis, dt, ldt, time, curr);

                ldt[curr] = Math.min(ldt[curr] , ldt[e.dest]); // compairing lowest discovery time of current node with its neighbour node

                // checking bridge condition

                if(dt[curr] < ldt[e.dest]) {
                    System.out.print(curr + " ---- " + e.dest);
                }
            }
            // for visited neighbour

            else {
                ldt[curr] = Math.min(ldt[curr] , ldt[e.dest]);
            }
        }
    }
    // bridge

    public static void bridge(ArrayList<Edge> graph[] , int v) {

        int dt[] = new int[v];
        int ldt[] = new int[v];
        int time = 0;
        boolean vis[] = new boolean[v];

        for(int i = 0; i < v; i += 1) {
            if(vis[i] == false) {
                dfs(graph, i, vis, dt, ldt, time, -1);
            }
        }
    }

    public static void main(String args[]) {
        int v = 6; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        bridge(graph, v);
    }
}
