class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0 or len(grid[0]) == 0:
            return 0
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        m, n = len(grid), len(grid[0])
        result = 0
        count = 0
        
        def dfs(x: int, y: int) -> int:
            nonlocal count
            if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == 0:
                return
            
            count += 1
            grid[x][y] = 0
            
            for direction in directions:
                dfs(x + direction[0], y + direction[1])
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    count = 0
                    dfs(i, j)
                    result = max(result, count)
        
        return result