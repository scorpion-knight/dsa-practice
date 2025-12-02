package com.gs.dsa.practice.dfs_backtracking;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirected {

    public static boolean hasCycle(int n, int[][] edges) {

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[n];

        boolean[] pathVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> graph,
                               boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, graph, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neigh]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
