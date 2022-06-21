class Solution {
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word)
    {
        int N = board.length, M = board[0].length;
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(board[i][j] == word.charAt(0) && dfs(i, j, board, 0, word, visited))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int x, int y, char[][] board, int curPos, String word, boolean[][] visited)
    {
        if(curPos == word.length())
        {
            return true;
        }
        
        int N = board.length, M = board[0].length;
        
        if(x < 0 || x >= N || y < 0 || y >= M || word.charAt(curPos) != board[x][y] || visited[x][y] == true)
        {
            return false;
        }
        
        visited[x][y] = true;
        
        for(int i = 0; i < 4; ++i)
        {
            int new_x = x + directions[i][0], new_y = y + directions[i][1];
            
            if(dfs(new_x, new_y, board, curPos + 1, word, visited))
            {
                return true;
            }
        }
        
        visited[x][y] = false;
        return false;
    }
}