package com.gs.dsa.practise.dfs_backtracking;

import com.gs.dsa.practice.dfs_backtracking.PathExists;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphPathTest {

    @Test
    void testPathExists() {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{1,3},{3,4}};
        assertTrue(PathExists.pathExists(n, edges, 0, 4));
    }

    @Test
    void testPathDoesNotExist() {
        int n = 5;
        int[][] edges = {{0,1},{2,3}};
        assertFalse(PathExists.pathExists(n, edges, 0, 4));
    }

    @Test
    void testEmptyGraph() {
        int n = 0;
        int[][] edges = {};
        assertFalse(PathExists.pathExists(n, edges, 0, 0));
    }

    @Test
    void testSrcEqualsDest() {
        int n = 5;
        int[][] edges = {{0,1},{1,2}};
        assertTrue(PathExists.pathExists(n, edges, 2, 2));
    }

    @Test
    void testDisconnectedGraph() {
        int n = 4;
        int[][] edges = {{0,1}};
        assertFalse(PathExists.pathExists(n, edges, 2, 3));
    }

    @Test
    void testSingleNodeGraph() {
        int n = 1;
        int[][] edges = {};
        assertTrue(PathExists.pathExists(n, edges, 0, 0));
    }

    @Test
    void testCycleGraph() {
        int n = 4;
        int[][] edges = {{0,1},{1,2},{2,0},{2,3}};
        assertTrue(PathExists.pathExists(n, edges, 0, 3));
    }
}
