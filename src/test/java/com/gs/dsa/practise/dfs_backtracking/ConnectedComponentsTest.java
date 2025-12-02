package com.gs.dsa.practise.dfs_backtracking;
import com.gs.dsa.practice.dfs_backtracking.ConnectedComponents;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectedComponentsTest {

    @Test
    public void testBasicExample() {
        assertEquals(2, ConnectedComponents.countComponents(5,
                new int[][]{{0,1},{1,2},{3,4}}));
    }

    @Test
    public void testNoEdges() {
        assertEquals(4, ConnectedComponents.countComponents(4,
                new int[][]{}));
    }

    @Test
    public void testFullyConnected() {
        assertEquals(1, ConnectedComponents.countComponents(4,
                new int[][]{{0,1},{1,2},{2,3},{3,0}}));
    }

    @Test
    public void testSingleNode() {
        assertEquals(1, ConnectedComponents.countComponents(1,
                new int[][]{}));
    }

    @Test
    public void testSeparatePairs() {
        assertEquals(3, ConnectedComponents.countComponents(6,
                new int[][]{{0,1},{2,3},{4,5}}));
    }

    @Test
    public void testChain() {
        assertEquals(1, ConnectedComponents.countComponents(5,
                new int[][]{{0,1},{1,2},{2,3},{3,4}}));
    }

    @Test
    public void testMixedIsolated() {
        assertEquals(4, ConnectedComponents.countComponents(6,
                new int[][]{{0,1},{1,2}}));
    }

    @Test
    public void testDuplicateEdges() {
        assertEquals(2  , ConnectedComponents.countComponents(3,
                new int[][]{{0,1},{1,0},{1,0},{0,1}}));
    }

    @Test
    public void testSelfLoops() {
        assertEquals(3, ConnectedComponents.countComponents(3,
                new int[][]{{0,0},{1,1}}));
    }

    @Test
    public void testLargeSparse() {
        assertEquals(4, ConnectedComponents.countComponents(7,
                new int[][]{{0,1},{2,3},{4,5}}));
    }

    @Test
    public void testLargeConnected() {
        assertEquals(1, ConnectedComponents.countComponents(7,
                new int[][]{{0,1},{1,2},{2,3},{3,4},{4,5},{5,6}}));
    }
}
