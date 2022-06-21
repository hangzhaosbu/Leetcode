class Solution {
    
    int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
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
                    dfs(i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int x, int y, char[][] grid)
    {
        int N = grid.length, M = grid[0].length;
        if(x < 0 || x >= N || y < 0 || y >= M)
        {
            return;
        }
        
        if(grid[x][y] == '0')
        {
            return;
        }
        
        grid[x][y] = '0';
        
        for(int i = 0; i < 4; ++i)
        {
            int new_x = x + directions[i][0], new_y = y + directions[i][1];
            dfs(new_x, new_y, grid);
        }
    }
}