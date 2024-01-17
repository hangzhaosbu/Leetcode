class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        area = {}
        color = 2
        m, n = len(grid), len(grid[0])
        
        ans = 0
        
        def getArea(x, y, m, n, color):
            if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] != 1:
                return 0
            
            grid[x][y] = color
            return 1 + getArea(x + 1, y, m, n, color) + getArea(x - 1, y, m, n, color) + getArea(x, y + 1, m, n, color) + getArea(x, y - 1, m, n, color)
        
        
        
        for i in range(m):
            for j in range(n):
                
                if grid[i][j] == 1:
                    
                    area[color] = getArea(i, j, m, n, color)
                    color += 1
        
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    curtArea = 1
                    
                    colors = set()
                    
                    
                    for x, y in [[i + 1, j], [i - 1, j], [i, j + 1], [i, j - 1]]:
                        if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == 0:
                            continue
                        colors.add(grid[x][y])
                    
                    
                    for color in colors:
                        curtArea += area[color]
                    
                    ans = max(ans, curtArea)
        
        return ans if ans != 0 else sum(area.values())
                    