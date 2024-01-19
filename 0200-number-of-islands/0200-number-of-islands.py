class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        m, n = len(grid), len(grid[0])
        
        def dfs(x, y, m, n):
            if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] != '1':
                return
            
            grid[x][y] = '0'
            
            for direction in [[1,0],[-1,0],[0,1],[0,-1]]:
                newx = x + direction[0]
                newy = y + direction[1]
                
                dfs(newx, newy, m, n)
            
        
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(i, j, m, n)
                    count += 1
        
        return count