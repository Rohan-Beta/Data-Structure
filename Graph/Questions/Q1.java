// There are a total of n tasks you have to pick, labelled from 0 to n-1.
// Some tasks may have prerequisites, for example to pick task 0 you have 
// to first pick task 1, which is expressed as a pair: [0, 1]


// Write a function:

// bool canFinish(int tasks, int[][] prerequisites) that returns if it is 
// possible for you to finish all tasks or not.

// Input: tasks = 2, prerequisites = [[1,0],[0,1]] Output: false

// Input: tasks = 3, prerequisites = [[1,0],[0,2]] Output: true

// time complexity is O(v + E)

import java.util.*;

class Firstclass {

    public static boolean isCycle(ArrayList<ArrayList<Integer>> graph , int curr , boolean vis[] , boolean rec[]) {

        vis[curr] = true;
        rec[curr] = true;

        for(int i = 0; i < graph.get(curr).size(); i += 1) {
            int neigh = graph.get(curr).get(i);

            if(rec[neigh] == true) {
                return true;
            }
            else if(vis[neigh] == false) {
                if(isCycle(graph, neigh, vis, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void topSorting(ArrayList<ArrayList<Integer>> graph , int curr , boolean vis[] , Stack<Integer> stack) {

        vis[curr] = true;

        for(int i = 0; i < graph.get(curr).size(); i += 1) {
            int neigh = graph.get(curr).get(i);

            if(vis[neigh] == false) {
                topSorting(graph, neigh, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static boolean solution(int task , int prerequisites[][]) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < task; i += 1) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i += 1) {

            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            graph.get(u).add(v);
        }
        boolean vis[] = new boolean[task];
        boolean rec[] = new boolean[task];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < task; i += 1) {
            if(vis[i] == false) {
                if(isCycle(graph, i, vis, rec)) {
                    return false;
                }
                else {
                    topSorting(graph, i, vis, stack);
                }
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.print("\n");

        return true;
    }

    public static void main(String args[]) {

        int task = 2;
        int prerequisites[][] = {{1 , 0}};

        System.out.print(solution(task, prerequisites));
    }
}
