class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        lim = len(grid), len(grid[0])
        
        def dfs(x, y):
            
            
            if x < 0 or x >= lim[0] or y < 0 or y >= lim[1] or grid[x][y] == '0':
                return
            
            
            grid[x][y] = "0"
            
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
            
            
        count = 0
        
        for i in range(lim[0]):
            for j in range(lim[1]):
                if grid[i][j] == '1':
                    dfs(i, j)
                    count += 1
                    
        return count