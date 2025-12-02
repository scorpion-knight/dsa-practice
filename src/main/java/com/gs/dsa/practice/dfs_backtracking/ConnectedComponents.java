package com.gs.dsa.practice.dfs_backtracking;

import java.util.*;

public class ConnectedComponents {

    public static int countComponents(int n, int[][] edges) {

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Since graph is UNDIRECTED, add both directions
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        // DFS from every unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(graph, i, visited);
            }
        }

        return components;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    // Test
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};

        System.out.println(countComponents(n, edges)); // Output: 2
    }
}

