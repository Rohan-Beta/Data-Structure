// All Paths from source to target

// time complexity is O(V^V) , V = vertices

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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    // all paths

    public static void allPath(ArrayList<Edge> graph[] , boolean visited[] , int curr , String path , int target) {

        if(curr == target) {
            System.out.print(path + "\n");
            return;
        }
        for(int i = 0; i < graph[curr].size(); i += 1) {
            Edge e = graph[curr].get(i);

            if(visited[e.dest] == false) {

                visited[curr] = true;
                allPath(graph, visited, e.dest, path+e.dest+" ", target);
                visited[curr] = false;
            }
        }
    }


    public static void main(String args[]) {
        int v = 7; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // create array of ArrayList

        createGraph(graph);

        boolean visited[] = new boolean[v];

        int src = 0;
        int target = 5;

        allPath(graph, visited, src, "0 ", target);
    }
}
