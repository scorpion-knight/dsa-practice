package com.gs.dsa.practise.dfs_backtracking;

import com.gs.dsa.practice.dfs_backtracking.DetectCycleDirected;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetectCycleDirectedTest {

    @Test
    public void testCycleExists() {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        assertTrue(DetectCycleDirected.hasCycle(n, edges));
    }

    @Test
    public void testNoCycle() {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        assertFalse(DetectCycleDirected.hasCycle(n, edges));
    }

    @Test
    public void testSelfLoop() {
        int n = 3;
        int[][] edges = {{0, 0}};
        assertTrue(DetectCycleDirected.hasCycle(n, edges));
    }

    @Test
    public void testEmptyGraph() {
        int n = 5;
        int[][] edges = {};
        assertFalse(DetectCycleDirected.hasCycle(n, edges));
    }

    @Test
    public void testDisconnectedGraphWithCycle() {
        int n = 6;
        int[][] edges = {
                {0, 1}, {1, 2},
                {3, 4}, {4, 5}, {5, 3}
        };
        assertTrue(DetectCycleDirected.hasCycle(n, edges));
    }
}
