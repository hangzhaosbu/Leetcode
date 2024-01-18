class Solution:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        m, n = len(grid), len(grid[0])
        ans = float("inf")
        buildingCount = 0
        
        q = []
        steps = [[0 for _ in range(n)] for _ in range(m)]
        reachCount = [[0 for _ in range(n)] for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    buildingCount += 1
                    visited = [[False if grid[x][y] == 0 else True for y in range(n)] for x in range(m)]
                    
                    q = [(i, j, 0)]
                    
                    while q:
                        
                        size = len(q)
                        
                        for _ in range(size):
                            x, y, step = q.pop(0)
                            
                            steps[x][y] += step
                            reachCount[x][y] += 1
                            
                            for direction in directions:
                                
                                newx, newy = x + direction[0], y + direction[1]
                                
                                if newx < 0 or newx >= m or newy < 0 or newy >= n or visited[newx][newy]:
                                    continue
                                
                                q.append((newx, newy, step + 1))
                                visited[newx][newy] = True
        
        for i in range(m):
            for j in range(n):
                if steps[i][j] != 0 and reachCount[i][j] == buildingCount:
                    ans = min(ans, steps[i][j])
        
        return ans if ans != float("inf") else -1
        