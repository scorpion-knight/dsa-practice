package com.gs.dsa.practice.dfs_backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathExists {
    public static boolean pathExists(int n, int[][] edges, int src, int dest) {

        // Edge case: empty graph
        if (n == 0) return false;

        // If source and destination are same
        if (src == dest) return true;

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);  // directed edge
        }

        // Track visited nodes
        boolean[] visited = new boolean[n];

        // DFS call
        return dfs(graph, src, dest, visited);
    }

    private static boolean dfs(List<List<Integer>> graph, int node, int dest, boolean[] visited) {

        if (node == dest) return true;      // Found path
        if (visited[node]) return false;    // Already explored

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (dfs(graph, neighbor, dest, visited)) {
                return true;
            }
        }

        return false;   // No path found
    }

    // Test the code
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{1,3},{3,4}};
        int src = 0, dest = 4;

        System.out.println(pathExists(n, edges, src, dest)); // true
    }
}
