class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        color = 2
        hashmap = {}
        ans = 0
        
        def getArea(x, y, m, n, color):
            if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] != 1:
                return 0
            
            grid[x][y] = color
            
            return 1 + getArea(x + 1, y, m, n, color) + getArea(x - 1, y, m, n, color) + getArea(x, y + 1, m, n, color) + getArea(x, y - 1, m, n, color)
        
        
        def getColor(x, y):
            if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] < 2:
                return None
            
            return grid[x][y]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    hashmap[color] = getArea(i, j, m, n, color)
                    color += 1
                    
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    curt = 1
                    for c in set([getColor(i + 1, j), getColor(i - 1, j), getColor(i, j + 1), getColor(i, j - 1)]):
                        if c == None:
                            continue
                        
                        curt += hashmap[c]
                    
                    ans = max(ans, curt)
        
        return ans if ans != 0 else hashmap[2]
                        
                    