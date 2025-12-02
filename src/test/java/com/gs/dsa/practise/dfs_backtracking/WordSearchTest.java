package com.gs.dsa.practise.dfs_backtracking;


import com.gs.dsa.practice.dfs_backtracking.WordSearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordSearchTest {

    @Test
    public void testWordExists() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        assertTrue(WordSearch.exist(board, "ABCCED"));
    }

    @Test
    public void testWordExistsDifferentPath() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        assertTrue(WordSearch.exist(board, "SEE"));
    }

    @Test
    public void testWordDoesNotExist() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        assertFalse(WordSearch.exist(board, "ABCB"));
    }

    @Test
    public void testEmptyBoard() {
        char[][] board = new char[0][0];
        assertFalse(WordSearch.exist(board, "A"));
    }

    @Test
    public void testWordLongerThanCells() {
        char[][] board = {
                {'A','B'},
                {'C','D'}
        };
        assertFalse(WordSearch.exist(board, "ABCDE"));
    }

    @Test
    public void testSingleLetterFound() {
        char[][] board = {
                {'A'}
        };
        assertTrue(WordSearch.exist(board, "A"));
    }

    @Test
    public void testSingleLetterNotFound() {
        char[][] board = {
                {'A'}
        };
        assertFalse(WordSearch.exist(board, "B"));
    }
}
