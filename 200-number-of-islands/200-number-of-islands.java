class Solution {
    public int numIslands(char[][] grid) 
    {
        int N = grid.length, M = grid[0].length, count = 0;
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(i, j, N, M, grid);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int x, int y, int N, int M, char[][] grid)
    {
        if(x < 0 || x >= N || y < 0 || y >= M || grid[x][y] == '0')
        {
            return;
        }
        grid[x][y] = '0';
        dfs(x + 1, y, N, M, grid);
        dfs(x - 1, y, N, M, grid);
        dfs(x, y + 1, N, M, grid);
        dfs(x, y - 1, N, M, grid);
    }
}