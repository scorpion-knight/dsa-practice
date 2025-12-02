package com.gs.dsa.practice.dfs_backtracking;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index,
                               int row, int col, boolean[][] visited) {

        if (index == word.length())
            return true;

        // boundary checks
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;

        // character mismatch or already used
        if (board[row][col] != word.charAt(index) || visited[row][col])
            return false;

        // mark visited
        visited[row][col] = true;

        // explore all four directions
        boolean found = dfs(board, word, index + 1, row + 1, col, visited)
                || dfs(board, word, index + 1, row - 1, col, visited)
                || dfs(board, word, index + 1, row, col + 1, visited)
                || dfs(board, word, index + 1, row, col - 1, visited);

        // backtrack
        visited[row][col] = false;

        return found;
    }
}
