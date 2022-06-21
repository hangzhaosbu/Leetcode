class Solution {
    
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        int N = board.length, M = board[0].length;
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(dfs(board, i, j, word, 0, visited))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int x, int y, String word, int curtPos, boolean[][] visited)
    {
        int N = board.length, M = board[0].length;
        
        if(curtPos == word.length())
        {
            return true;
        }
        
        if(x < 0 || x >= N || y < 0 || y >= M || word.charAt(curtPos) != board[x][y] || visited[x][y] == true)
        {
            return false;
        }
        
        visited[x][y] = true;
        
        for(int i = 0; i < 4; ++i)
        {
            int new_x = x + directions[i][0], new_y = y + directions[i][1];
            if(dfs(board, new_x, new_y, word, curtPos + 1, visited))
            {
                return true;
            }
        }
        
        visited[x][y] = false;
        return false;
    }
}